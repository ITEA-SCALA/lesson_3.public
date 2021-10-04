package com.itea.task2.dao

import com.itea.task2.entity.Clazz

class ClazzDao {
  def get(): Clazz = Clazz('1', "Title-1")
  def save(clazz: Clazz): Unit = println( "Entity: " + clazz ) // Entity: Clazz(2,Title-2)
}
