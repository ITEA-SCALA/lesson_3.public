package com.itea.task2.service

import com.itea.task2.dao._
import com.itea.task2.dto._
import com.itea.task2.service.mapper._

class ClazzService {
  private val dao: ClazzDao = new ClazzDao

  def get(): ClazzDto = ClazzToClazzDto( dao.get() )
  def save(clazz: ClazzDto): Unit = dao.save( ClazzDtoToClazz(clazz) )
}
