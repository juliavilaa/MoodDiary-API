package com.tiendamaria.repository

import com.tiendamaria.models.Producto

class ProductoRepository {

    private val productos = mutableListOf<Producto>()

    fun getAll() = productos

    fun getById(id: Int) = productos.find { it.id == id }

    fun save(producto: Producto) {
        productos.add(producto)
    }

    fun update(id: Int, producto: Producto): Boolean {
        val index = productos.indexOfFirst { it.id == id }
        return if (index != -1) {
            productos[index] = producto.copy(id = id)
            true
        } else false
    }

    fun delete(id: Int) = productos.removeIf { it.id == id }
}