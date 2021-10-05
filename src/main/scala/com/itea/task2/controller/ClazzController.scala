package com.itea.task2.controller

import io.bfil.automapper._

object ClazzController extends App {

  case class SourceClass(id: Int, label: String)
//  case class SourceClassDto(label: String, value: Int)
  case class SourceClassDto(label: String)

  val entity = SourceClass(10, "label")
  println( entity )

  val dto = automap(entity).to[SourceClassDto]
  println( dto )

}
