package com.teamsparta.todoproject.domain.todo.dto

import java.time.LocalDateTime

data class TodoResponseDto(
    val todoId:Long,
    val title:String,
    val content:String,
    val createAt:LocalDateTime,
    val nickName:String,
    val completed:Boolean
    )