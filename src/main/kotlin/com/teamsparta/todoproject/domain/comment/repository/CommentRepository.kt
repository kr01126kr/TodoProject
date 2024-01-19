package com.teamsparta.todoproject.domain.comment.repository

import com.teamsparta.todoproject.domain.comment.model.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository:JpaRepository<CommentEntity,Long> {

}