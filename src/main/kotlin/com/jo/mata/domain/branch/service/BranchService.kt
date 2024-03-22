package com.jo.mata.domain.branch.service

import com.jo.mata.domain.branch.dto.AddBranchRequest
import com.jo.mata.domain.branch.dto.UpdateBranchRequest
import com.jo.mata.domain.branch.repository.BranchRepository
import com.jo.mata.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BranchService(
    private val userRepository: UserRepository,
    private val branchRepository: BranchRepository
) {
    fun addBranch(request: AddBranchRequest) =
        (userRepository.findByIdOrNull(request.ownerId) ?: throw Exception("")) // TODO
            .let { branchRepository.save(request.to(it)) }

    @Transactional
    fun updateBranch(branchId: Long, request: UpdateBranchRequest) =
        (userRepository.findByIdOrNull(request.ownerId) ?: throw Exception("")) // TODO
            .let { branchRepository.findByIdOrNull(branchId) ?: throw Exception("") } // TODO
            .update(request)
}