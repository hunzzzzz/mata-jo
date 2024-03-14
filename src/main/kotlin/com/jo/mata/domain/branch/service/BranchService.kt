package com.jo.mata.domain.branch.service

import com.jo.mata.domain.branch.dto.AddBranchRequest
import com.jo.mata.domain.branch.repository.BranchRepository
import com.jo.mata.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BranchService(
    private val userRepository: UserRepository,
    private val branchRepository: BranchRepository
) {
    fun addBranch(request: AddBranchRequest) =
        (userRepository.findByIdOrNull(request.ownerId) ?: throw Exception("")) // TODO
            .let { branchRepository.save(request.to(it)) }
}