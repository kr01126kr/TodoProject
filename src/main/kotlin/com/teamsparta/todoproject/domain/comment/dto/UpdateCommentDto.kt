package com.teamsparta.todoproject.domain.comment.dto

data class UpdateCommentDto(
    val commentId:Long?,
    val commentContent:String,
    val commentName:String,
    val commentPassword:String

)
