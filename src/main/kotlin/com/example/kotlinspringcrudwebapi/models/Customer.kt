package com.example.kotlinspringcrudwebapi.models

import java.time.LocalDate
import java.time.LocalDateTime

data class Customer(
        val id: Long,
        val username: String,
        val password: String,
        val salt: String,
        val email: String,
        val firstName: String,
        val lastName: String,
        val dateOfBirth: LocalDate,
        val address: String,
        val stripeCustomerId: String,
        val createdAt: LocalDateTime
)
