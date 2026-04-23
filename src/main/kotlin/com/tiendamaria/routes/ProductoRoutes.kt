package com.tiendamaria.routes

import com.tiendamaria.controllers.ProductoController
import com.tiendamaria.models.Producto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureProductoRoutes() {

    val controller = ProductoController()

    routing {

        route("/productos") {

            get {
                call.respond(controller.listar())
            }

            get("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val producto = id?.let { controller.obtener(it) }

                if (producto != null) call.respond(producto)
                else call.respondText("No encontrado")
            }

            post {
                val producto = call.receive<Producto>()
                controller.crear(producto)
                call.respond(producto)
            }

            put("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val producto = call.receive<Producto>()

                if (id != null && controller.actualizar(id, producto))
                    call.respond(producto)
                else call.respondText("Error")
            }

            delete("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()

                if (id != null && controller.eliminar(id))
                    call.respondText("Eliminado")
                else call.respondText("Error")
            }
        }
    }
}