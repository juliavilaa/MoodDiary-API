package com.mooddiary.controllers

import com.mooddiary.models.Meta
import com.mooddiary.service.MetaService

class MetaController {
    private val service = MetaService()

    fun listar() = service.listar()
    fun obtener(id: Int) = service.obtener(id)
    fun listarPorUsuario(usuarioId: Int) = service.listarPorUsuario(usuarioId)
    fun crear(meta: Meta) = service.crear(meta)
    fun actualizar(id: Int, meta: Meta) = service.actualizar(id, meta)
    fun eliminar(id: Int) = service.eliminar(id)
}