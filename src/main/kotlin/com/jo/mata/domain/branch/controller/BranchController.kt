package com.jo.mata.domain.branch.controller

import com.jo.mata.domain.branch.service.BranchService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/branches")
class BranchController(
    private val branchService: BranchService
) {
}