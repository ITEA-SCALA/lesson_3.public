package com.itea.task1

import com.typesafe.config.ConfigFactory

object SimpleApp extends App {

  //
  val conf = ConfigFactory.load() // "application"
//  val conf = ConfigFactory.load("application2.conf") // system properties: No configuration setting found for key 'simple-app'

  println("simple-app.answer: " + conf.getString("simple-app.answer"))
  println("simple-lib.foo: " + conf.getString("simple-lib.foo"))
  println("simple-lib.whatever: " + conf.getString("simple-lib.whatever"))

  //
  case class ConfigDb(login: String, password: String, url: String)
  val configDb = conf.getAnyRef("config.db")
  println("ConfigDb: " + configDb)

}
