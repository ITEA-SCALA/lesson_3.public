package com.itea.task3

sealed class Iterator (var item: Item) {
  def next (): Item = {
    item = item.next
    item
  }

  def hasNext (): Boolean = item.next != NIL
}


object NIL extends Item {
  override def toString: String = "NIL"
}


object Item {
  def apply(): Item = new Item()
  def apply(value: AnyRef, item: Item): Item = new Item(value, item)
}

class Item(val value: AnyRef, item: Item) {

  var next: Item = NIL

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
    var l: Item = next
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
    var l: Item = next
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

  private def addWithoutList (v: AnyRef = null, i: Item = this): Unit = { next = new Item(v, i) }

  private def list (): Item = {
    var l: Item = next
    while (l.next != NIL) l = l.next
    l
  }
}
