package me.katsumag.csproject.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import me.katsumag.csproject.BinaryConverter
import me.katsumag.csproject.models.Component
import me.katsumag.csproject.shiftPoint

fun Route.componentRouting() {
    route("/api") {
        post {
            val component = call.receive<Component>()
            val exponent = BinaryConverter(component.exponent).toDenaryFirstNegative()
            val mantissa = shiftPoint(component.mantissa, exponent.toInt())
            val parts = mantissa.split(".")
            val first = BinaryConverter(parts[0]).toDenaryFirstNegative()
            val second = BinaryConverter(parts[1]).toDenaryReciprocals()
            val total = first + second

            call.respondText("Mantissa = $mantissa\nExponent = $exponent\nTotal = $total", status = HttpStatusCode.OK)
        }
    }
}


fun Application.registerComponentRoutes() {
    routing {
        componentRouting()
    }
}


