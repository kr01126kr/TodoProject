package com.teamsparta.todoproject.domain.user.service

import com.teamsparta.todoproject.domain.user.dto.LoginDto
import com.teamsparta.todoproject.domain.user.dto.SignUpDto
import com.teamsparta.todoproject.domain.user.dto.UserResponseDto
import com.teamsparta.todoproject.domain.user.model.UserEntity
import com.teamsparta.todoproject.domain.user.repository.UserRepository
import com.teamsparta.todoproject.domain.user.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {
    @Transactional
    override fun signUp(signUpDto: SignUpDto): UserResponseDto {
        if (userRepository.existsByEmail(signUpDto.email)) throw IllegalStateException("가입된 이메일")
        return UserEntity.toUserResponse(userRepository.save(UserEntity.toUserEntity(signUpDto)))

    }
    override fun login(loginDto: LoginDto): UserResponseDto {
        TODO()
    }
}