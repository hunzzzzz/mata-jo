package com.jo.mata.global.exception

import com.jo.mata.global.exception.cases.DuplicatedValueException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler(
    private val httpServletRequest: HttpServletRequest
) {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException) =
        ErrorResponse(
            httpStatus = "404 BAD REQUEST",
            field = e.fieldErrors.first().field,
            message = e.fieldErrors.first().defaultMessage!!,
            path = httpServletRequest.requestURI
        )

    @ExceptionHandler(DuplicatedValueException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleDuplicatedValueException(e: DuplicatedValueException) =
        ErrorResponse(
            httpStatus = "404 BAD REQUEST",
            field = e.message!!.let {
                it.substring(8, it.indexOf(".") - 3)
            },
            message = e.message.toString(),
            path = httpServletRequest.requestURI
        )
}