ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "scala_part1",
    idePackagePrefix := Some("com.rock_the_jvm")
  )
