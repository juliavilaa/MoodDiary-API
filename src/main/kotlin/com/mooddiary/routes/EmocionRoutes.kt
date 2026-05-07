package com.mooddiary.routes

import com.mooddiary.controllers.EmocionController
import com.mooddiary.models.Emocion
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureEmocionRoutes() {
    val controller = EmocionController()

    routing {
        route("/emociones") {
            get {
                call.respond(controller.listar())
            }

            get("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val emocion = id?.let { controller.obtener(it) }
                if (emocion != null) call.respond(emocion)
                else call.respondText("Emoción no encontrada")
            }

            // GET /emociones/usuario/{usuarioId}
            get("usuario/{usuarioId}") {
                val usuarioId = call.parameters["usuarioId"]?.toIntOrNull()
                if (usuarioId != null)
                    call.respond(controller.listarPorUsuario(usuarioId))
                else call.respondText("ID inválido")
            }

            post {
                val emocion = call.receive<Emocion>()
                controller.crear(emocion)
                call.respond(emocion)
            }

            put("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val emocion = call.receive<Emocion>()
                if (id != null && controller.actualizar(id, emocion))
                    call.respond(emocion)
                else call.respondText("Error al actualizar")
            }

            delete("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id != null && controller.eliminar(id))
                    call.respondText("Emoción eliminada")
                else call.respondText("Error al eliminar")
            }
        }
    }
}