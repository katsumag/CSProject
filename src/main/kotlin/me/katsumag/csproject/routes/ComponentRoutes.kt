package me.katsumag.csproject.routes

import me.katsumag.csproject.models.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import me.katsumag.csproject.BinaryConverter

fun Route.componentRouting() {
    route("/api") {
        post {
            val component = call.receive<Component>()
            val mantissa = BinaryConverter(component.mantissa).convert(false)
            val exponent = BinaryConverter(component.exponent).convert(true)
            call.respondText("Mantissa = $mantissa. Exponent = $exponent", status = HttpStatusCode.OK)
        }
    }
}


fun Application.registerComponentRoutes() {
    routing {
        componentRouting()
    }
}


