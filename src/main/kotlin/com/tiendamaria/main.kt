package com.tiendamaria

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

import io.ktor.server.plugins.cors.routing.*
import io.ktor.http.*

import com.tiendamaria.config.configureSerialization
import com.tiendamaria.routes.configureProductoRoutes

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0"
    ) {
        module()
    }.start(wait = true)
}

fun Application.module() {


    install(CORS) {
        anyHost()
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowHeader(HttpHeaders.ContentType)
    }

    configureSerialization()
    configureProductoRoutes()
}
