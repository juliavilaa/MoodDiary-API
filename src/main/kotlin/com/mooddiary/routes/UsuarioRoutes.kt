package com.mooddiary.routes

import com.mooddiary.controllers.UsuarioController
import com.mooddiary.models.Usuario
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val email: String, val password: String)

fun Application.configureUsuarioRoutes() {
    val controller = UsuarioController()

    routing {
        route("/usuarios") {
            get {
                call.respond(controller.listar())
            }

            get("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val usuario = id?.let { controller.obtener(it) }
                if (usuario != null) call.respond(usuario)
                else call.respondText("Usuario no encontrado")
            }

            post {
                val usuario = call.receive<Usuario>()
                controller.crear(usuario)
                call.respond(usuario)
            }

            put("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val usuario = call.receive<Usuario>()
                if (id != null && controller.actualizar(id, usuario))
                    call.respond(usuario)
                else call.respondText("Error al actualizar")
            }

            delete("{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id != null && controller.eliminar(id))
                    call.respondText("Usuario eliminado")
                else call.respondText("Error al eliminar")
            }
        }

        // Login
        post("/login") {
            val req = call.receive<LoginRequest>()
            val usuario = controller.login(req.email, req.password)
            if (usuario != null) call.respond(usuario)
            else call.respondText("Credenciales incorrectas")
        }
    }
}
