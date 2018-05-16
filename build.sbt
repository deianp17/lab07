name := "tema07"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.busymachines" %% "busymachines-commons-json" % "0.2.0",
  "com.busymachines" %% "busymachines-commons-rest-json" % "0.2.0",
  "com.busymachines" %% "busymachines-commons-effects" % "0.3.0-RC8",
  "com.typesafe" % "config" % "1.3.2",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.1",
  "com.typesafe.akka" %% "akka-http"   % "10.1.1",
  "com.typesafe.akka" %% "akka-stream" % "2.5.11",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "0.18",
  "io.spray" %% "spray-json" % "1.3.3"
)