name := "finch-hello"
organization := "com.yanananana"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.11.8"

assemblyJarName in assembly := "hello.jar"
assemblyMergeStrategy in assembly := {
  case "META-INF/io.netty.versions.properties" => MergeStrategy.first
  case x if x.endsWith(".class") => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
test in assembly := {}

fork in Test := true
javaOptions in Test ++= Seq(
  "-XX:MaxMetaspaceSize=512m"
)

scalacOptions := Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-Ywarn-dead-code", "-Ywarn-numeric-widen", "-Ywarn-unused-import",
  "-Xfuture",
  "-Yinline-warnings",
  "-Xlint",
  "-Ybackend:GenBCode",
  "-Ydelambdafy:method",
  "-target:jvm-1.8",
  "-optimize",
  "-Yopt:l:classpath"
)

val finchVersion = "0.11.1"

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % finchVersion,
  "com.github.finagle" %% "finch-circe" % finchVersion
)
.map(_ exclude("com.twitter", "finagle-netty4_2.11"))


