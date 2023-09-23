package com.rock_the_jvm

// extends app means this can be executed as standalone application
object Basics extends App{
    val meaningOfLife = 42

    println(meaningOfLife)

    val aBoolean = false

    val myList =  List[String] {"mike"}

    val result = myList.map(x => x.toUpperCase()).reduce( (x, y) => x + " " + y);
    println(result)

    val aComposedString = "I" + " " + "love" + " " + "scala"

    val anInterpolatedString = s"The meaning of life is $meaningOfLife"

    println(anInterpolatedString)

    val anExpression = 2 + 3

    val customText =
        if anExpression == 15 then "yes"
        else if anExpression == 5 then "yasss"
        else 15

    println(customText)

    val aCodeBlock = {
        val aLocalValue = 67

        aLocalValue + 3
    }

    println(myFunction(10, "hello "))
    assert(myFunction(10, "hello ") == myFunction2(10, "hello "))

    val factorial5 = factorial(5)
    println(factorial5)
    val factorialx = factorial(-1)
    println(factorialx)

    val factorial2Res = factorial2(5)
    println(factorial2Res)

    val factorial2Res2 = factorial2(-1)
    println(factorial2Res2)

    val theUnit = ()
    println(theUnit)
}

def factorial2(n: Int, acc: Int = 1): Int =
    if n < 1 then acc
    else factorial2(n - 1, acc * n)

def factorial(n: Int): Int =
    if n < 1 then 1
    else n * factorial(n - 1)

def myFunction(x: Int, y: String): String = {
    s"$y $x"
}

def myFunction2(x: Int, y: String): String = s"$y $x"
