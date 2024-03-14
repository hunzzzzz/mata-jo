package com.jo.mata.domain.branch.service

import com.jo.mata.domain.branch.repository.BranchRepository
import org.springframework.stereotype.Service

@Service
class BranchService(
    private val branchRepository: BranchRepository
) {
}