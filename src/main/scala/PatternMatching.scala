package com.rock_the_jvm

import scala.util.chaining.*

extension[A, B] (a: A)
    infix def |>(f: A => B): B = f(a)

object PatternMatching extends App {

    val anInteger = 55

    val intAsString = anInteger match {
        case 5 => "five"
        case 55 => "fifty-five"
        case _ => "unknown digit"
    }

    println(intAsString)

    case class Person(name: String, age: Int)

    case class AlsoPerson(name: String, age: Int)

    case class AlsoPerson2(namee: String, agee: Int)


    val bob = Person("Bob", 43)

    //    val name, age = bob match
    //    println(bob)
    //    println(name)
    //    println(age)

    val personGreeting = bob match {
        //        case AlsoPerson(n, a) => s"AlsoPerson Hi my name is $n and I amd $a years old." // this is not allowed
        case Person(n, a) => s"Person Hi my name is $n and I amd $a years old."
        case _ => "Something else"
    }

    val Person(n, a) = bob
    println(bob)
    println(s"name : $n")
    println(s"age: $a")

    println("\n deconstruct tuples")

    val personTuple = ("Bob", 43)

    val (name, age) = personTuple
    println(personTuple)
    println(s"name: $name")
    println(s"age: $age")

    def takeTuple(tuple: (String, Int)) = {
        tuple._1
    }

    println(takeTuple(personTuple))

    val x = 15 pipe (x => x * 2) pipe (_ + 5)

    // illegal
    //    val x2 = 15
    //        pipe (x => x * 2)
    //        pipe (_ + 5)

    println(x)

    val y = 15
        |> (x => x * 2)
        |> (_ + 5)
    println(y)

    val otherPersonTuple = ("Mike", 12)

    def matchTuple(tuple: (String, Int)): String = {
        tuple match {
            case (name, 12) => s"hello 12year old"
            case (name, age): (String, Int) if age < 18 => s"hello underage"
            case (name, age) => s"hello adult $name"
            case _ => s"hello stranger"
        }
    }

    val sixYearOld = ("tommy", 6)

    println(matchTuple(personTuple))
    println(matchTuple(otherPersonTuple))
    println(matchTuple(sixYearOld))


    val human1 = Person("mike", 12)
    val human2 = Person("John", 35)
    val human3 = Person("tommy", 6)

    def matchPerson(person: Person): String = {
        person match {
            case Person(name, 12) => s"Hello 12year old $name"
            case Person(name, age) if age < 18 => s"Hello underage $name"
            case Person(name, age) => s"Hello adult $name"
        }
    }

    println(matchPerson(human1))
    println(matchPerson(human2))
    println(matchPerson(human3))

    case class Family(father: Person, mother: Person)

    val family1 = Family(Person("John", 55), Person("kate", 43))
    val family2 = Family(Person("Mike", 23), Person("Jane", 25))

    def matchFamily(family: Family): String = {
        family match {
            case Family(father, Person(motherName, 43)) => s"mother's age is 43, that is weird"
            case Family(Person(fatherName, fatherAge), Person(motherName, motherAge)) =>
                s"father: $fatherName, mother: $motherName"
        }
    }

    println(matchFamily(family1))
    println(matchFamily(family2))

    val aList = List(1, 2, 3)

    val listDescription = aList match {
        case List(_, 2, 3) => "this list has '2' in the middle"
        case _ => "this is something"
    }

    println(listDescription)

    def matchListHead[T](list: List[T]): String =
        list match {
            case 1 :: 2 :: tail => "this list starts with 1 and then 2"
            case 1 :: tail => "this list starts with 1"
            case 0 :: tail => "this list starts with 0"
            case _ => "this is something"
        }

    println(matchListHead(List(1, 2, 3)))
    println(matchListHead(List(1, 0, 0)))
    println(matchListHead(List(0, 1, 0)))
    println(matchListHead(List(8, 1, 0)))


}
