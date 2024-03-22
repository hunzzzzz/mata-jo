package com.jo.mata.global.exception.cases

class DuplicatedValueException(value: String):
        RuntimeException("이미 존재하는 ${value}입니다.")