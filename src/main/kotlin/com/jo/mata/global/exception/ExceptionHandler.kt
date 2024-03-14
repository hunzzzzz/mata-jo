package com.jo.mata.global.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class ExceptionHandler(
    private val httpServletRequest: HttpServletRequest
) {
}