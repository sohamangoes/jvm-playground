plugins { id("com.diffplug.spotless") version ("6.25.0") }

repositories { gradlePluginPortal() }

spotless {
  java {
    target("**/*.java")
    googleJavaFormat()
    formatAnnotations()
  }

  kotlin {
    target("**/*.kt")
    ktfmt().googleStyle()
  }

  kotlinGradle {
    target("**/*.gradle.kts")
    ktfmt().googleStyle()
  }
}
