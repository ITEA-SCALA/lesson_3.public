package com.itea.task3

class Digital(id: Int = 0, title: String = "") {
  override def toString: String = s"{ id:$id, title:$title }"
}

object Digital {
  def apply(id: Int, title: String): Digital = new Digital(id, title)
}


object Application extends App {

  var iterator: Iterator = null

  val digitals: Storage = Storage()
  println( "isEmpty = " + digitals.isEmpty + ";  size = " + digitals.size + ";" ) // isEmpty = true;  size = 0;
//  println( items.iterator )
  digitals.print // NIL

  digitals add Digital(1, "one")
  digitals add Digital(2, "two")
  digitals add Digital(3, "three")
  digitals add Digital(4, "four")
  println( "\nisEmpty = " + digitals.isEmpty + ";  size = " + digitals.size + ";" ) // isEmpty = false;  size = 4;
//  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:3, title:three }  { id:4, title:four }
  iterator = digitals.iterator
  while ( iterator.hasNext ) {
    val next: Storage = iterator.next
    println( "value = " + next.value )
  }

  digitals.remove
  digitals.remove
  println( "\nisEmpty = " + digitals.isEmpty + ";  size = " + digitals.size + ";" ) // isEmpty = false;  size = 2;
//  items.print // NIL  { id:1, title:one }  { id:2, title:two }
  iterator = digitals.iterator
  while ( iterator.hasNext ) {
    val next: Storage = iterator.next
    println( "value = " + next.value )
  }

  digitals add Digital(33, "thirty three")
  digitals add Digital(44, "forty-four")
  digitals add Digital(55, "fifty five")
  println( "\nisEmpty = " + digitals.isEmpty + ";  size = " + digitals.size + ";" ) // isEmpty = false;  size = 5;
//  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:33, title:thirty three }  { id:44, title:forty-four }  { id:55, title:fifty five }
  iterator = digitals.iterator
  while ( iterator.hasNext ) {
    val next: Storage = iterator.next
    println( "value = " + next.value )
  }

  digitals.remove
  digitals.remove
  println( "\nisEmpty = " + digitals.isEmpty + ";  size = " + digitals.size + ";" ) // isEmpty = false;  size = 3;
//  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:33, title:thirty three }
  iterator = digitals.iterator
  while ( iterator.hasNext ) {
    val next: Storage = iterator.next
    println( "value = " + next.value )
  }

  digitals add Digital(444, "four hundred forty four")
  digitals add Digital(555, "five hundred fifty five")
  digitals add Digital(666, "six hundred sixty six")
  println( "\nisEmpty = " + digitals.isEmpty + ";  size = " + digitals.size + ";" ) // isEmpty = false;  size = 6;
//  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:33, title:thirty three }  { id:444, title:four hundred forty four }  { id:555, title:five hundred fifty five }  { id:666, title:six hundred sixty six }
  iterator = digitals.iterator
  while ( iterator.hasNext ) {
    val next: Storage = iterator.next
    println( "value = " + next.value )
  }
}
