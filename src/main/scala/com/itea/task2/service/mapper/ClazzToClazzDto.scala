package com.itea.task2.service.mapper

import com.itea.task2.dto.ClazzDto
import com.itea.task2.entity.Clazz

object ClazzToClazzDto {
  def apply(entity: Clazz): ClazzDto = ClazzDto( entity.title )
}
