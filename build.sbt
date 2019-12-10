name := "barter-core"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.googlecode.json-simple" % "json-simple" % "1.1.1",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  "mysql" % "mysql-connector-java" % "6.0.4",
  jdbc , cache
)

play.Project.playJavaSettings
