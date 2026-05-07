package com.mooddiary.models

import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    val id: Int,
    val usuarioId: Int,
    val nombre: String,
    val completada: Boolean = false
)