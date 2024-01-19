package com.teamsparta.todoproject.domain.todo.dto

import java.time.LocalDateTime

data class CreateTodoDto(
    val title:String,
    val content:String,
    val createAt:LocalDateTime,
    val nickName:String

)
