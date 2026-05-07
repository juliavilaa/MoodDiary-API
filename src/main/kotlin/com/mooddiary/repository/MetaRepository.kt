package com.mooddiary.repository

import com.mooddiary.models.Meta

class MetaRepository {

    private val metas = mutableListOf<Meta>()

    fun getAll() = metas

    fun getById(id: Int) = metas.find { it.id == id }

    fun getByUsuario(usuarioId: Int) = metas.filter { it.usuarioId == usuarioId }

    fun save(meta: Meta) = metas.add(meta)

    fun update(id: Int, meta: Meta): Boolean {
        val index = metas.indexOfFirst { it.id == id }
        return if (index != -1) {
            metas[index] = meta.copy(id = id)
            true
        } else false
    }

    fun delete(id: Int) = metas.removeIf { it.id == id }
}