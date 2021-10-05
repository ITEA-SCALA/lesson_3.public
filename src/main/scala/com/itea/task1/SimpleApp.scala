package com.itea.task1

import com.typesafe.config.ConfigFactory

object SimpleApp extends App {

  val conf = ConfigFactory.load()

  println("simple-app.answer: " + conf.getString("simple-app.answer"))
  println("simple-lib.foo: " + conf.getString("simple-lib.foo"))
  println("simple-lib.whatever: " + conf.getString("simple-lib.whatever"))

}
