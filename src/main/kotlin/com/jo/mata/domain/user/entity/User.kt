package com.jo.mata.domain.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    val role: UserRole,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String
) {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    val id: Long? = null
}