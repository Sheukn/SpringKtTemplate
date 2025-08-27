package com.springktskeleton.entity

import jakarta.persistence.*

@Entity
@Table(name = "hello")
data class HelloEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String
)
