package com.jo.mata.domain.branch.controller

import com.jo.mata.domain.branch.dto.AddBranchRequest
import com.jo.mata.domain.branch.dto.UpdateBranchRequest
import com.jo.mata.domain.branch.service.BranchService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/branches")
class BranchController(
    private val branchService: BranchService
) {
    @PostMapping
    fun addBranch(@RequestBody @Valid request: AddBranchRequest) =
        ResponseEntity.created(URI.create("/")).body(branchService.addBranch(request))

    @PutMapping("/{branchId}")
    fun updateBranch(
        @PathVariable branchId: Long,
        @RequestBody @Valid request: UpdateBranchRequest
    ) = ResponseEntity.ok().body(branchService.updateBranch(branchId, request))
}