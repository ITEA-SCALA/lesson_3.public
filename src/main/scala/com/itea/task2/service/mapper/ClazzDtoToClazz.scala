package com.itea.task2.service.mapper

import com.itea.task2.dto.ClazzDto
import com.itea.task2.entity.Clazz

object ClazzDtoToClazz {
  def apply(dto: ClazzDto): Clazz = Clazz( dto.title.last, dto.title )
}
