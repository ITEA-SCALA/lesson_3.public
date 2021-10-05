package com.itea.task1

import com.typesafe.config.{Config, ConfigFactory}

object SimpleApp extends App {

  // # 0.
  val conf = ConfigFactory.load() // "application"
//  val conf = ConfigFactory.load("application2.conf") // system properties: No configuration setting found for key 'simple-app'

  println("simple-app.answer: " + conf.getString("simple-app.answer"))
  println("simple-lib.foo: " + conf.getString("simple-lib.foo"))
  println("simple-lib.whatever: " + conf.getString("simple-lib.whatever"))

  // # 1.
  val dbConfig1 = conf.getAnyRef("config.db")
  println("DbConfig-1: " + dbConfig1)

  /*
   * # 2.
   * TODO Exception in thread "main" scala.MatchError: {password=mysecretpassword, login=myuser, url=jdbc://mysql.....} (of class java.util.HashMap)
   */
//  def mapper(dbConfig: AnyRef): DbConfig = dbConfig match {
//    case config: DbConfig => DbConfig(login=config.login, password=config.password, url=config.url)
////    case _ => DbConfig
//  }
//
//  val dbConfig2: DbConfig = mapper( conf.getAnyRef("config.db") )
////  println("db.login = " + dbConfig2.login)

//  val url = conf.getConfig("config.db").getString("url")
//  println("url: " + url)
  //
  val dbConfig2: Config = conf.getConfig("config.db")
  val url = dbConfig2.getString("url")
  println("url: " + url)

}
