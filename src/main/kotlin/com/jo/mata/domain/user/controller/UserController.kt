package com.jo.mata.domain.user.controller

import com.jo.mata.domain.user.service.UserService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {
}