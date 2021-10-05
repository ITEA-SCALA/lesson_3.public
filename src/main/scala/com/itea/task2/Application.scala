package com.itea.task2

import com.itea.task2.service.ClazzService
import com.itea.task2.dto.ClazzDto

object Application extends App {

  val service: ClazzService = new ClazzService
  println( "DTO:    " + service.get() ) // DTO:    Clazz(Title-1)
  service.save( ClazzDto("Title-2") )
}
