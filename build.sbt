ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "ZioBegins",
    idePackagePrefix := Some("com.katchfashion.nyltics")
  )
libraryDependencies += "dev.zio" %% "zio" % "2.0.6"
libraryDependencies += "dev.zio" %% "zio-test" % "2.0.6"
libraryDependencies += "dev.zio" %% "zio-mock" % "1.0.0-RC9"
