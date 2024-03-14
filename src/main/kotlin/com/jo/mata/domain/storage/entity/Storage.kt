package com.jo.mata.domain.storage.entity

import com.jo.mata.domain.branch.Branch
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "storage")
class Storage(
    @Column(name = "number", nullable = false)
    val number: Int,

    @ManyToOne
    val branch: Branch
) {
    @Id
    @GeneratedValue
    @Column(name = "storage_id")
    val id: Long? = null
}