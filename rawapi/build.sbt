name := "rawapi"

version := "0.2.5"

autoScalaLibrary := false

crossPaths := false

javaSource in Compile := baseDirectory.value / "gen-swift"
