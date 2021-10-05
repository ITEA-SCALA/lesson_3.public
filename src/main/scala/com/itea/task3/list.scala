package com.itea.task3

sealed class Iterator (var item: Storage) {
  def next (): Storage = {
    item = item.next
    item
  }

  def hasNext (): Boolean = item.next != NIL
}


object NIL extends Storage {
  override def toString: String = "NIL"
}


object Storage {
  def apply(): Storage = new Storage()
  def apply(value: AnyRef, item: Storage): Storage = new Storage(value, item)
}

class Storage(val value: AnyRef, item: Storage) {

  var next: Storage = NIL

  def this() = {
    this(null, NIL)
    addWithoutList(i = NIL)
  }

  //TODO: добавить элемент в конец списка
  def add (v: AnyRef): Unit = {
    val l = list
    l.addWithoutList(v)
  }

  //TODO: удалить последний элемент в списке
  def remove (): Unit = {
    var l: Storage = next
    while (l.next != NIL) {
      if (l.next.next == NIL) l.next = NIL
      else l = l.next
    }
  }

  // TODO: распечатать все элементы списка
  def print = println( list() )

  // если список пустой
  def isEmpty: Boolean = size() == 0

    // количество элементов в списке
  def size (): Int = {
    var s = 0
    var l: Storage = next
    while (l.next != NIL) {
      l = l.next
      s += 1
    }
    s
  }

  // для перебора элементов списка
  def iterator (): Iterator = new Iterator(next)

  override def toString: String = {
    if (item != NIL) s"$item  $value"
    else s"$item"
  }

  private def addWithoutList (v: AnyRef = null, i: Storage = this): Unit = { next = new Storage(v, i) }

  private def list (): Storage = {
    var l: Storage = next
    while (l.next != NIL) l = l.next
    l
  }
}
