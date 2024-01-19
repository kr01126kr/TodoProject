package com.teamsparta.todoproject.domain.todo.repository

import com.teamsparta.todoproject.domain.todo.model.TodoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository:JpaRepository<TodoEntity,Long> {
}