package com.itea.task2.rest.route

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.itea.task2.service.HealthService


object HealthRoute {
  val service: HealthService = HealthService()

  val healthRoute: Route =
    path("health") {
      get {
        complete(service.get.toString)
      }
    }
}