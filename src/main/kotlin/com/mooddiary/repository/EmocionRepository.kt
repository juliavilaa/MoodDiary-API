package com.mooddiary.repository

import com.mooddiary.models.Emocion

class EmocionRepository {

    private val emociones = mutableListOf<Emocion>()

    fun getAll() = emociones

    fun getById(id: Int) = emociones.find { it.id == id }

    fun getByUsuario(usuarioId: Int) = emociones.filter { it.usuarioId == usuarioId }

    fun save(emocion: Emocion) = emociones.add(emocion)

    fun update(id: Int, emocion: Emocion): Boolean {
        val index = emociones.indexOfFirst { it.id == id }
        return if (index != -1) {
            emociones[index] = emocion.copy(id = id)
            true
        } else false
    }

    fun delete(id: Int) = emociones.removeIf { it.id == id }
}