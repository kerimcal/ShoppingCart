name := "ShoppingCart"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= {
  Seq(
    "org.scalactic"       %%  "scalactic"     % "3.0.1",
    "org.scalatest"       %%  "scalatest"     % "3.0.1" % "test",
    "org.mockito"         %   "mockito-all"   % "1.10.19" % "test"
  )
}