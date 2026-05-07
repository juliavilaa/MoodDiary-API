package com.mooddiary.controllers

import com.mooddiary.models.Usuario
import com.mooddiary.service.UsuarioService

class UsuarioController {
    private val service = UsuarioService()

    fun listar() = service.listar()
    fun obtener(id: Int) = service.obtener(id)
    fun crear(usuario: Usuario) = service.crear(usuario)
    fun actualizar(id: Int, usuario: Usuario) = service.actualizar(id, usuario)
    fun eliminar(id: Int) = service.eliminar(id)
    fun login(email: String, password: String) = service.login(email, password)
}