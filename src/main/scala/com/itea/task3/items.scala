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

class Item(val value: AnyRef, item: Item) { //TODO параметры конструктора можно инициализировать при передаче

  var next: Item = NIL //TODO private var next: Item = NIL

  def this() = { //TODO но если нужно еще инициировать вызов метода - тогда это лучше сделать в теле вызова другого конструктора...
    this(null, NIL)
    addWithoutList(i=NIL)
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

  def isEmpty: Boolean = size() == 0

  def size (): Int = {
    var s = 0
    var l: Item = next
    while (l.next != NIL) {
      l = l.next
      s += 1
    }
    s
  }

  def iterator (): Iterator = new Iterator(next)

  //TODO: распечатать все элементы списка
  def print = println( list() )

  override def toString: String = {
    if (item != NIL) s"$item  $value" //TODO только по нулевому элементу 'NIL' будем выполнять условие...
    else s"$item"
  }

  /*
   * https://stackoverflow.com/questions/39210830/why-in-scala-long-cannot-in-initialized-to-null-whear-as-integer-can
   * TODO Int и Long являются типами Scala и являются производными от AnyVal, который не является ссылочным типом (т. е. не является AnyRef) и, следовательно, не может быть null
   */
  private def addWithoutList (v: AnyRef = null, i: Item = this): Unit = { next = new Item(v, i) }

  private def list (): Item = {
    var l: Item = next
    while (l.next != NIL) l = l.next
    l
  }
}
