package com.itea.task2.service.mapper

class ClazzConverter {
  def convert( entity: com.itea.task2.entity.Clazz ): com.itea.task2.dto.Clazz = com.itea.task2.dto.Clazz( entity.title )
  def convert( dto: com.itea.task2.dto.Clazz ): com.itea.task2.entity.Clazz = com.itea.task2.entity.Clazz( dto.title.last, dto.title )
}
