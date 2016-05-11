resolvers += Resolver.url("sbt-plugin-releases-scalasbt", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "twitter-repo" at "http://maven.twttr.com"

// Create fat jar
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.2")
