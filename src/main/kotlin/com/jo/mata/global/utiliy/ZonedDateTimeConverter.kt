package com.jo.mata.global.utiliy

import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object ZonedDateTimeConverter {
    // String 날짜+시간 데이터 -> ZonedDateTime 날짜+시간 데이터
    fun convertStringDateTimeIntoZonedDateTime(dateTime: String): ZonedDateTime =
        ZonedDateTime.of(
            LocalDate.parse(
                dateTime,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            ).atStartOfDay(),
            ZoneId.of("Asia/Seoul")
        )

    // ZonedDateTime 날짜+시간 데이터 -> String 날짜+시간 데이터
    fun convertZonedDateTimeIntoStringDateTime(dateTime: ZonedDateTime): String =
        dateTime.format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        )
}