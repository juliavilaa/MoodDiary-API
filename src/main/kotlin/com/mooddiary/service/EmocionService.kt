package com.mooddiary.service

import com.mooddiary.models.Emocion
import com.mooddiary.repository.EmocionRepository

class EmocionService {
    private val repo = EmocionRepository()

    fun listar() = repo.getAll()
    fun obtener(id: Int) = repo.getById(id)
    fun listarPorUsuario(usuarioId: Int) = repo.getByUsuario(usuarioId)
    fun crear(emocion: Emocion) = repo.save(emocion)
    fun actualizar(id: Int, emocion: Emocion) = repo.update(id, emocion)
    fun eliminar(id: Int) = repo.delete(id)
}