package com.itea.task2.rest.route

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.itea.task2.service.HealthService
import akka.event.Logging
import com.itea.task2.rest.HealthRest.{ system }

object HealthRoute {
  implicit val log = Logging(system, "HealthRoute$")
  val service: HealthService = HealthService()

  val doGet: Route =
    path("health") {
      get {
        val dto = service.get
        log.info(s"Server get health $dto")
        complete(service.get.toString) //TODO  { label: 'health-1', status: true }
      }
    }
}