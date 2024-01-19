package com.teamsparta.todoproject.domain.comment.service

import com.teamsparta.todoproject.domain.comment.dto.CommentResponseDto
import com.teamsparta.todoproject.domain.comment.dto.CreateCommentDto
import com.teamsparta.todoproject.domain.comment.dto.DeleteCommentDto
import com.teamsparta.todoproject.domain.comment.dto.UpdateCommentDto

interface CommentService {
    fun createComment(createCommentDto: CreateCommentDto): CommentResponseDto
    fun updateComment(commentId: Long,updateCommentDto: UpdateCommentDto): CommentResponseDto
    fun deleteComment(commentId: Long,deleteCommentDto: DeleteCommentDto)
}