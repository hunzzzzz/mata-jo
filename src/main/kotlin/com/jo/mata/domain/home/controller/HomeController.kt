package com.jo.mata.domain.home.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/")
    fun home() = "마타조(Mata-Jo)에 오신 것을 환영합니다!"
}