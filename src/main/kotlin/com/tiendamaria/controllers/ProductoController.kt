package com.tiendamaria.controllers

import com.tiendamaria.models.Producto
import com.tiendamaria.service.ProductoService

class ProductoController {

    private val service = ProductoService()

    fun listar() = service.listar()

    fun obtener(id: Int) = service.obtener(id)

    fun crear(producto: Producto) = service.crear(producto)

    fun actualizar(id: Int, producto: Producto) =
        service.actualizar(id, producto)

    fun eliminar(id: Int) = service.eliminar(id)
}