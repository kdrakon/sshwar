name := "sshwar"

version := "0.1"

scalaVersion := "2.10.4"

seq(webSettings :_*)

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

libraryDependencies += "org.atmosphere" % "atmosphere-runtime" % "2.1.1"

libraryDependencies += "javax.websocket" % "javax.websocket-api" % "1.0"

libraryDependencies += "net.schmizz" % "sshj" % "0.9.0"

libraryDependencies ++= Seq(
  "org.apache.tomcat.embed" % "tomcat-embed-core"         % "7.0.22" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-logging-juli" % "7.0.22" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-jasper"       % "7.0.22" % "container"
)
