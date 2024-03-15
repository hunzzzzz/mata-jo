package com.jo.mata.global.exception

import com.jo.mata.global.utiliy.ZonedDateTimeConverter
import java.time.ZonedDateTime

data class ErrorResponse(
    val httpStatus: String,
    val field: String,
    val message: String,
    val path: String,
    val time: String = ZonedDateTimeConverter.convertZonedDateTimeIntoStringDateTime(ZonedDateTime.now())
)