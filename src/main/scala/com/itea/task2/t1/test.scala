package com.itea.task2.t1

import io.bfil.automapper._

case class SourceClass(label: String, value: Int)
case class TargetClass(label: String, value: Int)


trait MyMappings {
  implicit val mapping1 = generateMapping[SourceClass, TargetClass]
}

object MyMappings extends App {

  //
  val source = SourceClass("label", 10)
  val target = automap(source).to[TargetClass]
  println( source )
  println( target )

  //
  val target1 = automap(source).to[TargetClass]
  println( target1 )

}
