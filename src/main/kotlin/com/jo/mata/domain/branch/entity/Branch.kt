package com.jo.mata.domain.branch.entity

import com.jo.mata.domain.user.entity.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "branches")
class Branch(
    @Column(name = "address", nullable = false)
    val address: String,

    @ManyToOne
    val user: User
) {
    @Id
    @GeneratedValue
    @Column(name = "branch_id")
    val id: Long? = null
}