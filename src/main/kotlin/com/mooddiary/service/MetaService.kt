package com.mooddiary.service

import com.mooddiary.models.Meta
import com.mooddiary.repository.MetaRepository

class MetaService {
    private val repo = MetaRepository()

    fun listar() = repo.getAll()
    fun obtener(id: Int) = repo.getById(id)
    fun listarPorUsuario(usuarioId: Int) = repo.getByUsuario(usuarioId)
    fun crear(meta: Meta) = repo.save(meta)
    fun actualizar(id: Int, meta: Meta) = repo.update(id, meta)
    fun eliminar(id: Int) = repo.delete(id)
}