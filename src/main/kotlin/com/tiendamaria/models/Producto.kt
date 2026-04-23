package com.tiendamaria.models

import kotlinx.serialization.Serializable

@Serializable
data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imagen: String = ""
)