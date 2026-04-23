package com.tiendamaria.service

import com.tiendamaria.models.Producto
import com.tiendamaria.repository.ProductoRepository

class ProductoService {

    private val repo = ProductoRepository()

    fun listar() = repo.getAll()

    fun obtener(id: Int) = repo.getById(id)

    fun crear(producto: Producto) = repo.save(producto)

    fun actualizar(id: Int, producto: Producto) =
        repo.update(id, producto)

    fun eliminar(id: Int) = repo.delete(id)
}