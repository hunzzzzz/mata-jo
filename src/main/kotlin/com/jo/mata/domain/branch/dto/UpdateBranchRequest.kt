package com.jo.mata.domain.branch.dto

import com.jo.mata.domain.branch.entity.Branch
import com.jo.mata.domain.user.entity.User
import jakarta.validation.constraints.NotBlank

data class UpdateBranchRequest(
    @field:NotBlank(message = "지점 주소는 필수 입력 사항입니다.")
    val address: String,

    @field:NotBlank(message = "지점명은 필수 입력 사항입니다.")
    val name: String,

    val ownerId: Long // TODO : 추후 인증/인가 기능이 구현되면 수정
) {
    fun to(user: User) = Branch(
        address = address,
        name = name,
        owner = user
    )
}
