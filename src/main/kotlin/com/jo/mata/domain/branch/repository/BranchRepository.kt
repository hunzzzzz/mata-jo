package com.jo.mata.domain.branch.repository

import com.jo.mata.domain.branch.entity.Branch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BranchRepository : JpaRepository<Branch, Long> {
    fun existsByAddress(address: String): Boolean

    fun existsByName(name: String): Boolean

    fun findByName(name: String): Branch?
}