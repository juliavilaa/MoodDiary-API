package com.mooddiary.service

import com.mooddiary.models.Usuario
import com.mooddiary.repository.UsuarioRepository

class UsuarioService {
    private val repo = UsuarioRepository()

    fun listar() = repo.getAll()
    fun obtener(id: Int) = repo.getById(id)
    fun obtenerPorEmail(email: String) = repo.getByEmail(email)
    fun crear(usuario: Usuario) = repo.save(usuario)
    fun actualizar(id: Int, usuario: Usuario) = repo.update(id, usuario)
    fun eliminar(id: Int) = repo.delete(id)

    fun login(email: String, password: String): Usuario? {
        return repo.getByEmail(email)?.takeIf { it.password == password }
    }
}