package com.itea.task2.controller.http

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{PathMatcher, Route}
import io.bfil.automapper.automap


case class SourceClass(id: Int ,label: String)
case class TargetClass(id: Int ,label: String)

object HealthRoute {
  val entity = SourceClass(10, "label")
  val dto = automap(entity).to[TargetClass]

  val healthRoute: Route =
    path("health") {
      get {
//        complete(StatusCodes.OK)
        complete(dto.toString)
      }
    }
}