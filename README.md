
## Null, null, Nil, Nothing, None, and Unit in Scala

* `Scala и пустота` http://programador.ru/scala-and-nothing/
  * https://ru.stackoverflow.com/questions/668479/Зачем-нужны-nothing-null-nil-и-none
* ( https://www.baeldung.com/scala/nil-null-nothing-unit-none )
  * ( https://sanaulla.info/2009/07/12/nothingness-2/ )

### Null

Null – это trait. Объект null (с маленькой буквы) — это как раз и есть объект типа Null. Он находится внизу иерархии типов в Scala, в противовес AnyRef.

Благодаря этому вы всегда можете как-бы "занулить" любую ссылку, т.е. присвоить ссылки значение null:

Null работает только для ссылочных типов, для более общего случая, есть "ничто (Nothing)".

### Nothing

Nothing – это тоже trait. Nothing находится на самом дне иерархии типов, в противовес Any. Соответственно, это более общий тип, чем Null и подходит даже для AnyVal объектов (числа, буквы, правда/ложь и т.д.).

В отличие от Null, Nothing не может иметь экземпляров (на то оно и ничто).
Другими словами нет аналога null для Nothing.

Возникает вопрос, где такое самое "нижнее ничто" может использоваться?
Этот метод никогда ничего не возвращает, поэтому возвращаемый тип Nothing.
```scala
// пакет scala.sys
def error(message: String): Nothing = throw new RuntimeException(message)
```

### Unit

Unit – класс, чем-то похоже на void, который используется в Java. В Scala тип Unit применяется тогда, когда нужно показать, что функция возвращает пустое значение (но все-таки что-то возвращает, хоть и пустое).

Если открыть документацию, то можно увидеть что:
```scala
class Unit extends Any with AnyVal
```

Внимание! AnyVal, а не AnyRef. Это значит, что Unit это не ссылочный тип ( в отличие от Null). Можно сказать, что Unit-у как бы "ближе по родству" будут числа, буквы и другие примитивные типы (которые тоже AnyVal).

В отличие от Nothing, Unit повезло больше. Он может иметь свой объект, правда в единственном экземпляре. Он обозначается двумя круглыми скобками: ().

Другими словами Nothing уместен тогда, когда функция в принципе ничего не возвращает, а Unit – это когда возвращает, но оно пустое.
Это отличие существенно. Например результат вызова функции с Unit может быть присвоено (в Java с void такой фокус не выйдет).

### Nil

Nil – объект, пустой список (extends List[Nothing]).

Поскольку Nil – это список, хоть и пустой, у него как у любого списка есть метод :: (два двоеточия), с помощью которого удобно создавать списки:
```scala
var x = 1 :: 2 :: Nil
x: List[Int] = List(1, 2)
```

Это возможно благодаря тому, что название метода заканчивается на : (двоеточие), в таком случае метод применяется к правому операнду (работает для операторной нотации вызова метода).

Другими словами, это аналогично вызову: (Nil.::(2)).::(1)

### None

None – это такой хитрый объект (extends Option[Nothing]) , который используется в случае, если мы хотим получить что-то, например, из Map, а его там нет.
```scala
var m = Map(1->2)
m: scala.collection.immutable.Map[Int,Int] = Map(1 -> 2)
val n = m.get(100)// ну нет такого элемента
n: Option[Int] = None
```

None примечателен тем, что:

это объект (т.е. синглтон)
это кейс-объект
наследуется от Option[Nothing]
В случае попытки получить значение (вызвав метод n.get()), мы получим исключение:java.util.NoSuchElementException.

Если у None вызывать метод isEmpty() – мы получим true.

Поскольку None – объект кейс-класса, то мы можем его "матчить" (сопоставлять по шаблону).
```scala
n match { 
 case Some(x) => println("x:" + x) 
 case None => println("none") 
}
```

Если у None вызвать метод toList – мы получим пустой список (т.е. Nil).

```scala
n.toList() == Nil
res21: Boolean = true
```

Поскольку None объявлен как extends Option[Nothing], а Nothing – "самое нижнее ничто", то None может работать с любыми типами (как с ссылочными так и с примитивными).


---


* `Case objects vs Enumerations in Scala * Solution` https://newbedev.com/case-objects-vs-enumerations-in-scala
* `Enumeration in Scala` https://www.geeksforgeeks.org/enumeration-in-scala/
* https://www.baeldung.com/scala/enumerations
  * https://otfried.org/scala/enumerations.html
  * ( https://dotty.epfl.ch/docs/reference/enums/enums.html )
  * ( https://github.com/scala/scala-java8-compat )


---

[GitHub * Personal access tokens](https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox/KtbxLwgswrfxtLZJbFzLlPHzglccGQBXXV)

[Zoom * Ссылка на запись 3 занятия](https://us02web.zoom.us/rec/play/BVXbBOF66hy3Xq-xi171bmAgoFsICqY9kxgZUlZySZqLjwZB2IfI77pHjKR_i9ZJVqgZFfSFaT7J6Qu3.r55iJ_NmMQDWEPdk?continueMode=true&_x_zm_rtaid=DNO7J3GWQR6EHNMzIJSxIQ.1633248736226.db941ca5fe7f0beb344ebfdca1724bc4&_x_zm_rhtaid=812)