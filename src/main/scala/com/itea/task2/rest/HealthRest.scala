package com.itea.task2.rest

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.itea.task2.rest.route.HealthRoute

object HealthRest extends App {

  implicit val system: ActorSystem = ActorSystem("akka-http")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val port = 8080
  val bindingFuture = Http().bindAndHandle(HealthRoute.doGet, "localhost", port)

  implicit val log = Logging(system, "main")
  log.info(s"Server started at the port $port")

}
