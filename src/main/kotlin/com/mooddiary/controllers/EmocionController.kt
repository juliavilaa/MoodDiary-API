package com.mooddiary.controllers

import com.mooddiary.models.Emocion
import com.mooddiary.service.EmocionService

class EmocionController {
    private val service = EmocionService()

    fun listar() = service.listar()
    fun obtener(id: Int) = service.obtener(id)
    fun listarPorUsuario(usuarioId: Int) = service.listarPorUsuario(usuarioId)
    fun crear(emocion: Emocion) = service.crear(emocion)
    fun actualizar(id: Int, emocion: Emocion) = service.actualizar(id, emocion)
    fun eliminar(id: Int) = service.eliminar(id)
}