package com.teamsparta.todoproject.domain.todo.service

import com.teamsparta.todoproject.domain.exception.ModelNotFoundException
import com.teamsparta.todoproject.domain.todo.dto.CreateTodoDto
import com.teamsparta.todoproject.domain.todo.dto.RetrieveTodoDto
import com.teamsparta.todoproject.domain.todo.dto.TodoResponseDto
import com.teamsparta.todoproject.domain.todo.dto.UpdateTodoDto
import com.teamsparta.todoproject.domain.todo.model.TodoEntity
import com.teamsparta.todoproject.domain.todo.model.toResponse
import com.teamsparta.todoproject.domain.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository,
): TodoService {
    override fun getTodo(todoId:Long): RetrieveTodoDto? {
        val findTodo = todoRepository.findByIdOrNull(todoId)?: throw ModelNotFoundException("todo",todoId)
        return findTodo?.let { RetrieveTodoDto.from(it) }
    }
    override fun getTodoList():List<TodoResponseDto> {
        return todoRepository.findAll().map{it.toResponse()}
    }
    @Transactional
    override fun createTodo(createTodoDto: CreateTodoDto): TodoResponseDto {
        return todoRepository.save(
            TodoEntity(
                title = createTodoDto.title,
                content = createTodoDto.content,
                creatAt = createTodoDto.createAt,
                nickName = createTodoDto.nickName
            )
        ).toResponse()
    }
    @Transactional
    override fun updateTodo(todoId: Long,updateTodoDto: UpdateTodoDto): TodoResponseDto {
        val updateTodo = todoRepository.findByIdOrNull(todoId)?: throw ModelNotFoundException("todo",todoId)
            updateTodo.title = updateTodoDto.title
            updateTodo.content = updateTodoDto.content
            updateTodo.nickName =  updateTodoDto.nickName
        return todoRepository.save(updateTodo).toResponse()
    }
    @Transactional
    override fun deleteTodo(todoId: Long) {
        val deleteTodo = todoRepository.findByIdOrNull(todoId)?: throw ModelNotFoundException("todo",todoId)
        todoRepository.delete(deleteTodo)

    }
    @Transactional
    override fun completedTodo(todoId: Long): TodoResponseDto {
        val todoCompleted = todoRepository.findByIdOrNull(todoId)?: throw ModelNotFoundException("todo",todoId)

            todoCompleted?.let{
                it.complete()
                todoRepository.save(it)
            }
        return todoCompleted.toResponse()
    }
}