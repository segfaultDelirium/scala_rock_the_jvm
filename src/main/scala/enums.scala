package com.rock_the_jvm

import StatusEnum2.Ok

sealed trait Status
object Status {
    case object Ok extends Status
    case object Nok extends Status
}

object StatusEnum extends Enumeration {
    val Ok, Nok = Value
}

enum StatusEnum2:
    case Ok, Nok

object enums extends App{

    val ok = Status.Ok
    val nok = Status.Nok

    // this shows warning that match may not be exhaustive
    def statusToString(s: Status): String = s match {
        case Status.Ok => "alright!"
    }

    def statusToString2(s: Status): String = s match {
        case Status.Ok => "alright!"
        case Status.Nok => "nope"
    }

    println(Status.Ok)
    println(StatusEnum.Ok)
    println(StatusEnum2.Ok)

    // no warning about non exhaustive match when using object extends Enumeration!
    def statusEnumToString(s: StatusEnum.Value): String = s match {
        case StatusEnum.Ok => "alright"
    }

    // you get a warning when using plain enum
    def statusEnum2ToString(s: StatusEnum2): String = s match{
        case Ok => "alright"
    }

    println(statusToString(ok))
//    println(statusToString(nok)) // will cause runtime exception

    val statusList = List(StatusEnum2.Ok, StatusEnum2.Nok)
    println(statusList)


//    val res = ok match
//        case Status.Ok => "alright!"
//
//    println(res)
}
