organization := "io.tremblay"
name := "spark-starter"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.6"
libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.10.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.2" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.1" % "provided" exclude("org.apache.hadoop", "hadoop-client")

// Parsers
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs@_*) => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf" => MergeStrategy.concat
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

// Build info
excludeFilter in excludeFilter in(Compile, unmanagedSources) := "BuildInfo.scala"
lazy val root = (project in file(".")).
  enablePlugins(BuildInfoPlugin).
  settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "buildinfo"
  )