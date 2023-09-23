package com.rock_the_jvm

case class Foo(i: Int)

class Bar(i: Int, s: String) extends Foo(i)

object CaseClass extends App{
    assert(new Bar(1, "foo") == new Bar(1, "bar"))
}
