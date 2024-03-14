package com.jo.mata.domain.user.service

import com.jo.mata.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
}