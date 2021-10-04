package com.itea.task2.service

import com.itea.task2.dao.ClazzDao
import com.itea.task2.dto.Clazz
import com.itea.task2.service.mapper.ClazzConverter

class ClazzService extends ClazzConverter {
  private val dao: ClazzDao = new ClazzDao

  def get(): Clazz = convert( dao.get() )
  def save(clazz: Clazz): Unit = dao.save( convert(clazz) )
}
