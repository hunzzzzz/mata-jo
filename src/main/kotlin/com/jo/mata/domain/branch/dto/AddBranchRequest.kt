package com.jo.mata.domain.branch.dto

import com.jo.mata.domain.branch.entity.Branch
import com.jo.mata.domain.user.entity.User

data class AddBranchRequest(
    val address: String,
    val name: String,
    val ownerId: Long // TODO : 추후 인증/인가 기능이 구현되면 수정
) {
    fun to(user: User) = Branch(
        address = address,
        name = name,
        owner = user
    )
}
