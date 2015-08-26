scalaVersion := "2.11.6"

scalaSource in Compile <<= baseDirectory(_ / "src")

javaSource in Compile <<= baseDirectory(_ / "src")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xlint", "-Xfatal-warnings",
                      "-encoding", "us-ascii")

javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path",
                     "-encoding", "us-ascii")

libraryDependencies ++= Seq(
  "org.nlogo" % "NetLogo" % "5.3.0" from
    (baseDirectory.value.getParentFile.getParentFile / "target" / "NetLogo.jar").toURI.toString,
    // "http://ccl.northwestern.edu/netlogo/5.3.0/NetLogo.jar",
  "jssc" % "jssc" % "2.6.0" from
    "http://ccl.northwestern.edu/devel/jssc-2.6.0.jar"
)

name := "gogo-serial"

NetLogoExtension.settings

NetLogoExtension.classManager := "org.nlogo.extensions.gogoserial.GoGoSerialExtension"
