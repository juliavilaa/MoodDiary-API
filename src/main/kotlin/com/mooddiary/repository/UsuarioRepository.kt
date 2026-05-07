package com.mooddiary.repository

import com.mooddiary.models.Usuario

class UsuarioRepository {

    private val usuarios = mutableListOf<Usuario>()

    fun getAll() = usuarios

    fun getById(id: Int) = usuarios.find { it.id == id }

    fun getByEmail(email: String) = usuarios.find { it.email == email }

    fun save(usuario: Usuario) = usuarios.add(usuario)

    fun update(id: Int, usuario: Usuario): Boolean {
        val index = usuarios.indexOfFirst { it.id == id }
        return if (index != -1) {
            usuarios[index] = usuario.copy(id = id)
            true
        } else false
    }

    fun delete(id: Int) = usuarios.removeIf { it.id == id }
}