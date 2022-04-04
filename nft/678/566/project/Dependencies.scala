import sbt._

object Dependencies {

  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework",
  ).map(_ % "3.6.1" % Test)

  lazy val gatlingPicatinny: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-picatinny",
  ).map(_ % "0.8.0")

  lazy val janino: Seq[ModuleID] = Seq(
    "org.codehaus.janino" % "janino",
  ).map(_ % "3.1.2")

  lazy val jdbc_plugin: Seq[ModuleID] = Seq("ru.tinkoff" % "gatling-jdbc-plugin_2.13").map(_ % "<current version>")

  lazy val postgresJdbc: Seq[ModuleID] = Seq("org.postgresql" % "postgresql").map(_ % "<current version>")

}
