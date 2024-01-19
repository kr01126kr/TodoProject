package com.teamsparta.todoproject.domain.todo.service

import com.teamsparta.todoproject.domain.todo.dto.CreateTodoDto
import com.teamsparta.todoproject.domain.todo.dto.RetrieveTodoDto
import com.teamsparta.todoproject.domain.todo.dto.TodoResponseDto
import com.teamsparta.todoproject.domain.todo.dto.UpdateTodoDto

interface TodoService {
    fun getTodo(todoId:Long): RetrieveTodoDto?
    fun getTodoList():List<TodoResponseDto>
    fun createTodo(createTodoDto: CreateTodoDto): TodoResponseDto
    fun updateTodo(todoId: Long,updateTodoDto: UpdateTodoDto): TodoResponseDto
    fun deleteTodo(todoId: Long)
    fun completedTodo(todoId: Long): TodoResponseDto
}