package com.itea.task3

//import com.itea.task3.list11.Item
import com.itea.task3.list20.{Item, Iterator}


class Some(id: Int = 0, title: String = "") {
  override def toString: String = s"{ id:$id, title:$title }"
}

object Some {
  def apply(id: Int, title: String): Some = new Some(id, title)
}


object Application extends App {

  // (1)
//  val items: Item = Item()
//  items add 1
//  items add 2
//  items add 3
//  items add 4
//  items.print // NIL 1 2 3 4
//
//  items.remove()
//  items.remove()
//  items.print // NIL 1 2
//
//  items add 33
//  items add 44
//  items add 55
//  items.print // NIL 1 2 33 44 55
//
//  items.remove()
//  items.remove()
//  items.print // NIL 1 2 33
//
//  items add 444
//  items add 555
//  items add 666
//  items.print // NIL 1 2 33 444 555 666

  // (2)
  var iterator: Iterator = Iterator()

  val items: Item = Item()
  println( "isEmpty = " + items.isEmpty + ";  size = " + items.size + ";" ) // isEmpty = true;  size = 0;
  //  println( items.iterator )
  items.print // NIL

  items add Some(1, "one")
  items add Some(2, "two")
  items add Some(3, "three")
  items add Some(4, "four")
  println( "\nisEmpty = " + items.isEmpty + ";  size = " + items.size + ";" ) // isEmpty = false;  size = 4;
  //  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:3, title:three }  { id:4, title:four }
  iterator = items.iterator
  while ( iterator.hasNext ) {
    val next: Item = iterator.next
    println( "value = " + next.value )
  }

  items.remove
  items.remove
  println( "\nisEmpty = " + items.isEmpty + ";  size = " + items.size + ";" ) // isEmpty = false;  size = 2;
  //  items.print // NIL  { id:1, title:one }  { id:2, title:two }
  iterator = items.iterator
  while ( iterator.hasNext ) {
    val next: Item = iterator.next
    println( "value = " + next.value )
  }

  items add Some(33, "thirty three")
  items add Some(44, "forty-four")
  items add Some(55, "fifty five")
  println( "\nisEmpty = " + items.isEmpty + ";  size = " + items.size + ";" ) // isEmpty = false;  size = 5;
  //  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:33, title:thirty three }  { id:44, title:forty-four }  { id:55, title:fifty five }
  iterator = items.iterator
  while ( iterator.hasNext ) {
    val next: Item = iterator.next
    println( "value = " + next.value )
  }

  items.remove
  items.remove
  println( "\nisEmpty = " + items.isEmpty + ";  size = " + items.size + ";" ) // isEmpty = false;  size = 3;
  //  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:33, title:thirty three }
  iterator = items.iterator
  while ( iterator.hasNext ) {
    val next: Item = iterator.next
    println( "value = " + next.value )
  }

  items add Some(444, "four hundred forty four")
  items add Some(555, "five hundred fifty five")
  items add Some(666, "six hundred sixty six")
  println( "\nisEmpty = " + items.isEmpty + ";  size = " + items.size + ";" ) // isEmpty = false;  size = 6;
  //  items.print // NIL  { id:1, title:one }  { id:2, title:two }  { id:33, title:thirty three }  { id:444, title:four hundred forty four }  { id:555, title:five hundred fifty five }  { id:666, title:six hundred sixty six }
  iterator = items.iterator
  while ( iterator.hasNext ) {
    val next: Item = iterator.next
    println( "value = " + next.value )
  }
}
