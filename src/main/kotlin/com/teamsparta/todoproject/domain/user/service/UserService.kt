package com.teamsparta.todoproject.domain.user.service

import com.teamsparta.todoproject.domain.user.dto.LoginDto
import com.teamsparta.todoproject.domain.user.dto.SignUpDto
import com.teamsparta.todoproject.domain.user.dto.UserResponseDto

interface UserService {
    fun signUp(signUpDto: SignUpDto): UserResponseDto
    fun login(loginDto: LoginDto): UserResponseDto

}