package com.mooddiary.models

import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String,
    val password: String,
    val edad: Int
)