package com.itea.task2.controller

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.itea.task2.controller.http.HealthRoute

object SimpleHttp extends App {

  implicit val system: ActorSystem = ActorSystem("simple-http")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val port = 8080
  val bindingFuture = Http().bindAndHandle(HealthRoute.healthRoute, "localhost", port)

  implicit val log = Logging(system, "main")
  log.info(s"Server started at the port $port")

}