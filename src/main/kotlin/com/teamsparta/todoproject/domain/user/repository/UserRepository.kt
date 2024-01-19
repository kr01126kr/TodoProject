package com.teamsparta.todoproject.domain.user.repository

import com.teamsparta.todoproject.domain.user.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<UserEntity,Long> {
    fun existsByEmail(email:String):Boolean
}