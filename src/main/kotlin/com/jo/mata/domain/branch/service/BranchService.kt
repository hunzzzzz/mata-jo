package com.jo.mata.domain.branch.service

import com.jo.mata.domain.branch.dto.AddBranchRequest
import com.jo.mata.domain.branch.dto.UpdateBranchRequest
import com.jo.mata.domain.branch.entity.Branch
import com.jo.mata.domain.branch.repository.BranchRepository
import com.jo.mata.domain.user.repository.UserRepository
import com.jo.mata.global.exception.cases.DuplicatedValueException
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
            .let {
                checkDuplicationInAdd(request.address, request.name)
                branchRepository.save(request.to(it))
            }

    @Transactional
    fun updateBranch(branchId: Long, request: UpdateBranchRequest) =
        (userRepository.findByIdOrNull(request.ownerId) ?: throw Exception("")) // TODO
            .let { branchRepository.findByIdOrNull(branchId) ?: throw Exception("") } // TODO
            .let {
                checkDuplicationInUpdate(request.address, request.name, it)
                it.update(request)
            }

    // 지점 등록 시 address, name 중복 체크
    private fun checkDuplicationInAdd(address: String, name: String) {
        if (branchRepository.existsByAddress(address)) throw DuplicatedValueException("지점 주소")
        else if (branchRepository.existsByName(name)) throw DuplicatedValueException("지점명")
    }

    // 지점 정보 수정 시 address, name 중복 체크
    private fun checkDuplicationInUpdate(address: String, name: String, branch: Branch) {
        if (branchRepository.existsByAddress(address) && branch.address != address) throw DuplicatedValueException("지점 주소")
        else if (branchRepository.existsByName(name) && branch.name != name) throw DuplicatedValueException("지점명")
    }
}