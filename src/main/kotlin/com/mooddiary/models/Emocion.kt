package com.mooddiary.models

import kotlinx.serialization.Serializable

@Serializable
data class Emocion(
    val id: Int,
    val usuarioId: Int,
    val tipo: String,        // Feliz, Triste, Enojado, Calmado, Ansioso
    val descripcion: String,
    val fecha: String
)