plugins {
  id("java")
  id("org.jetbrains.intellij") version "1.17.3"
  kotlin("jvm")
}

group = "com.palmerovicdev.astroinitializer"
version = "0.0.1"

repositories {
  mavenCentral()
}

java {
}

// See https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
  version.set("2024.1")
}

tasks {
  buildSearchableOptions {
    enabled = false
  }

  patchPluginXml {
    version.set("${project.version}")
    sinceBuild.set("232")
    untilBuild.set("241.*")
  }
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
}
kotlin {
  jvmToolchain(17)
}