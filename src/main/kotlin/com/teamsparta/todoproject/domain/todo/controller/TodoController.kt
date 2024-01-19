package com.teamsparta.todoproject.domain.todo.controller

import com.teamsparta.todoproject.domain.todo.dto.CreateTodoDto
import com.teamsparta.todoproject.domain.todo.dto.RetrieveTodoDto
import com.teamsparta.todoproject.domain.todo.dto.TodoResponseDto
import com.teamsparta.todoproject.domain.todo.dto.UpdateTodoDto
import com.teamsparta.todoproject.domain.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RequestMapping("/todos")
@RestController
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping("/{todoId}")
    fun getTodo(
        @PathVariable todoId:Long
    ):ResponseEntity<RetrieveTodoDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodo(todoId))
    }
    @GetMapping()
    fun getTodoList():ResponseEntity<List<TodoResponseDto>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodoList())
    }
    @PostMapping
    fun createTodo(
        @RequestBody createTodoDto: CreateTodoDto
    ):ResponseEntity<TodoResponseDto>
    {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(createTodoDto))
    }
    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId:Long,
        @RequestBody updateTodoDto: UpdateTodoDto
    ):ResponseEntity<TodoResponseDto>
    {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.updateTodo(todoId, updateTodoDto))
    }
    @PutMapping("/{todoId}/complete")
    fun completedTodo(
        @PathVariable todoId:Long
    ):ResponseEntity<TodoResponseDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.completedTodo(todoId))
    }
    @DeleteMapping("/{todoId}")
    fun deleteTodo(
        @PathVariable todoId: Long,
    ):ResponseEntity<Unit>
    {
        todoService.deleteTodo(todoId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }


}