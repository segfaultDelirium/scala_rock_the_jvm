package com.rock_the_jvm

import ObjectOrientation.{Animal, Dog, MyList}

object ObjectOrientation extends App {

    class Animal {
        // define fields
        val age: Int = 0

        def eat() = println("I'm eating")
    }

    val animal: Animal = new Animal

    animal.eat()

    // constructor arguments are not fields
    // to promote constructor argument to field add "val" before constructor argument
    class Dog(val lastName: String, name: String) extends Animal {
        override def eat() = println(s"$name $lastName is eating...")

        def equals(dog: Dog): Boolean = {
            return lastName == dog.lastName
        }
    }

    val dog = new Dog("lawman", "backster")

    dog.eat()
    println(dog.lastName)
    //    println(dog.name) // this will error since name is not a class field

    val aDeclaredAnimal: Animal = new Dog("hachi", "man")
    aDeclaredAnimal.eat()

    println("")
    invokeEat(aDeclaredAnimal)
    invokeEat(animal)
    invokeEat(dog)

    // all fields and members by default public
    // you can set private or protected explicitly
    abstract class WalkingAnimal {
        val hasLegs = true

        def walk(): Unit
    }

    // interface - ultimate abstract type

    // scala can have multi trait inheritance
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    class Crocodile extends Animal with Carnivore with Philosopher {
        override def eat(animal: Animal): Unit = println(s"I am eating you, animal!")

        override def ?!(thought: String): Unit = {
            println(s"Crocodile is thinking $thought")
        }

        //        override def eat(): Unit = super.eat()
    }

    val croc = new Crocodile()
    croc.eat(dog)
    croc.eat()

    croc eat dog // infix notation, only available for methods with one argument

    croc ?! "ug ugg ug uggg"

    trait Philosopher {
        def ?!(thought: String): Unit
    }

    croc ?! "what if we could fly"

    val basicMath = 1 + 2
    val basicMath2 = 1.+(2)
    assert(basicMath == basicMath2)

    val dog2 = new Dog("mike", "tyson")
    val dog3 = new Dog("mike", "tyson")
    assert(dog2 equals dog3)

    // anonymous class based on carnivore trait
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Unit = println("I am a dinosaur so i can eat anything!")
    }

    dinosaur.eat(aDeclaredAnimal)

    val snake = new Object {
        def eat(animal: Animal): Unit = println("I am a snake so I eat mice")
    }

    //    snake eat aDeclaredAnimal this is impossible

    val sample_function = (x: Int) => x * 2
    val res = sample_function.apply(10)
    println(res)

    val res2 = sample_function {
        10
    }
    println(res2)

    val sample_function2 = (x: Int, y: Int) => x * y

    val res3 = sample_function2.curried {
        22
    } {
        10
    }


    // singleton object
    // method apply allows to call: MySingleton(54) in addition to MySingleton.apply(54)
    object MySingleton {
        val mySpecialValue = 54435;

        def mySpecialMethod(): Int = 5327


        def apply(x: Int): Int = x + 1
    }

    println(MySingleton.mySpecialValue)
    println(MySingleton.mySpecialMethod())
    println(MySingleton(54) == MySingleton.apply(54))
    println()

    // objects with the same name as existing class are called companions
    // companion objects can access each others private fields or methods
    // singleton object Animal and instances of Animal class are different things
    object Animal {
        val canLiveIndefinately = false
    }

    val animalsCanLiveForever = Animal.canLiveIndefinately // like static field / method

    // case classes - lightweight data structures with some boilerplate

    // compiler automatically creates sensible equals and hash codes
    // and serialization
    // may be constructed without keyword 'new'
    case class Person(name: String, age: Int)

    val person1 = Person("mike", 123)
    val person2 = Person("mike", 123)
    assert(person1 == person2)
    println(person1)
    println(dog)

    // exceptions

    try {
        val x: String = null
        println(x.length)
    } catch {
        case e: Exception => println(s"some faulty exception ${e.getMessage()}")
    } finally {
        println("execute some code no matter what")
    }
    println()
    val x = try {
        val x: String = null
        s"$x.length"
    } catch {
        case e: Exception => s"some faulty exception ${e.getMessage()}"
    }

    println(x)

    abstract class MyList[T] {
        def head: T

        def tail: MyList[T]

        def apply(x: T): MyList[T]
    }

    //    val intList  = new MyList[Int]{
    //
    //    }

    val aList: List[Int] = List(1, 2, 3) // List.apply(1,2,3)
    val first = aList.head
    val rest = aList.tail

    val aStringList = List("hello", "scala")
    val firstString = aStringList.find(_ => true) match {
        case Some(x) => x
        case None => throw new Exception()
    }
    println(firstString)

    val firstString2 = aStringList.find(_ => true).get
    println(firstString2)

    val reversedList = aList.reverse
    println(reversedList)


}

def invokeEat(animal: Dog): Unit = {
    println("invoking eat for dog")
    animal.eat()
}

def invokeEat(animal: Animal): Unit = {
    println("invoking eat for animal")
    animal.eat()
}


