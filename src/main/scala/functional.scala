package com.rock_the_jvm

object functional extends App {

    class Person(name: String) {
        def apply(age: Int) = println(s"I have aged $age years")
    }

    val bob = new Person("Bob")

    bob.apply(43)
    bob(43)

    val simpleIncrementer = new Function1[Int, Int] {
        override def apply(arg: Int): Int = arg + 1
    }

    // we basically defined a function
    val res = simpleIncrementer(10)
    println(res)

    val composed = simpleIncrementer.compose((x: Int) => x * 10)

    val composedRes = composed(3)
    println(composedRes)

    val StringConcatenator = new Function2[String, String, String] {
        override def apply(v1: String, v2: String): String = v1 + v2
    }

    println(StringConcatenator("I love ", "Scala"))

    val doubler: Function1[Int, Int] = (x: Int) => x * 2
    println(doubler(4))

    val doubler2: Int => Int = (x: Int) => x * 2

    val doubler3 = (x: Int) => x * 2

    // higher order functions
    // take functions as args or return functions

    val aMappedList = List(1, 2, 3).map(x => s"element: $x\n")
    println(aMappedList)

    val aMappedList2 = List(1, 2, 3).map(x => x * 2)

    val aFlatMappedList = List(1, 2, 3).flatMap(x => List(x, 2 * x))
    println(aFlatMappedList)
    println {
        aFlatMappedList
    }

    val aFlatMappedList2 = List(1, 2, 3).flatMap {
        x => List(x, x * 2)
    }
    println {
        aFlatMappedList2
    }
    val aFlatMappedList3 = List(1, 2, 3).map(x => List(x, x * 2)).flatten
    assert(aFlatMappedList2 == aFlatMappedList3)

    val evenList = List(1, 2, 3, 4, 5)
        .map(x => {
            println(s"first mapping $x")
            x
        })
        .filter(x => {
            println("filtering x")
            x % 2 == 0
        })
        .map(x => {
            println(s"second mapping $x")
            x
        })
    println(evenList)

    println("normal list vs lazy list\n")
    val evenList2 = LazyList(1, 2, 3, 4, 5)
        .map(x => {
            println(s"first mapping $x")
            x
        })
        .filter(x => {
            println("filtering x")
            x % 2 == 0
        })
        .map(x => {
            println(s"second mapping $x")
            x
        }).toList
    println(evenList2)

    val aFilteredList4 = List(1, 2, 3, 4, 5).filter(_ % 2 == 0)
    println(aFilteredList4)

    // all pairs between the numbers (1,2,3) and letters ('a', 'b', 'c')

    val numbers = List(1, 2, 3)
    val letters = List('a', 'b', 'c')

    val pairs = numbers.flatMap(number => letters.map(letter => List(number, letter)))
    println(pairs)
    println(pairs.flatten)

    val pairs2 = numbers.map(number => letters.map(letter => List(number, letter)))
    println(pairs2.flatten)

    // for comprehensions
    val pairs3 = for {
        number <- numbers
        letter <- letters
    } yield List(number, letter)
    println(pairs3)


    println("collections")

    println("lists")

    val aList = List(1, 2, 3, 4, 5, 6)
    val first = aList.head
    val rest = aList.tail
    println(s"first: $first, rest: $rest")

    val aPrependedList = 0 :: aList
    println(aPrependedList)

    val anExtendedList = 0 +: aList :+ 7
    println(anExtendedList)

    val head :: tail = aList
    println(s"head: $head, tail: $tail")

    println("\nsequences")

    println("sequence allows accessing element at given index")
    val aSequence: Seq[Int] = Seq(1, 2, 3, 1, 2)
    println(aSequence)
    println(aSequence(3))


    println("\n vectors are good for performance")
    val aVector = Vector(1, 2, 3, 4)
    println(aVector)
    println(aVector(2))

    println("\n sets are collections with no duplicate elements")

    val aSet = Set(1, 2, 3, 4, 6, 7)
    val setHas5 = aSet.contains(5)
    println(aSet)
    println(setHas5)

    val setWith5 = aSet + 5
    println(setWith5)
    println(setWith5.contains(5))
    println("order of items in set is not determined")

    val listFromSet = setWith5.toList
    println(listFromSet)

    val setWithout5 = setWith5 - 5
    println(setWithout5)


    val aRange = 1 to 10
    val twoByTwo = aRange.map(x => 2 * x).toList

    println(aRange)
    println(twoByTwo)

    println("\ntuples")

    val aTuple = ("Bon Jovi", "Rock", 1982)
    val aTuple2 = ("Bon Jovi", "Rock", 1982)
    println(aTuple)
    assert(aTuple == aTuple2)

    println("\n map")
    val aPhone: Map[String, Int] = Map(
        ("Daniel", 123),
        ("Michael", 554),
        "Jane" -> 43546
    )

    println(s"daniels phone number is ${aPhone.get("Daniel").get}")
    println(s"daniels phone number is ${aPhone("Daniel")}")
    println(s"daniels phone number is ${aPhone("Jane")}")




}
