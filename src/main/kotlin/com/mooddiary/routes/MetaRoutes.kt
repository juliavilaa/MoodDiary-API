package com.mooddiary.routes

import com.mooddiary.controllers.MetaController
import com.mooddiary.models.Meta
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureMetaRoutes() {
    val controller = MetaController()

    routing {
        route("/metas") {
            get {
                call.respond(controller.listar())
            }

            get("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val meta = id?.let { controller.obtener(it) }
                if (meta != null) call.respond(meta)
                else call.respondText("Meta no encontrada")
            }

            // GET /metas/usuario/{usuarioId}
            get("usuario/{usuarioId}") {
                val usuarioId = call.parameters["usuarioId"]?.toIntOrNull()
                if (usuarioId != null)
                    call.respond(controller.listarPorUsuario(usuarioId))
                else call.respondText("ID inválido")
            }

            post {
                val meta = call.receive<Meta>()
                controller.crear(meta)
                call.respond(meta)
            }

            put("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val meta = call.receive<Meta>()
                if (id != null && controller.actualizar(id, meta))
                    call.respond(meta)
                else call.respondText("Error al actualizar")
            }

            delete("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id != null && controller.eliminar(id))
                    call.respondText("Meta eliminada")
                else call.respondText("Error al eliminar")
            }
        }
    }
}