plugins { id("com.diffplug.spotless") version ("6.25.0") }

repositories { gradlePluginPortal() }

spotless {
  protobuf { buf() }

  shell {
    target("**/*.sh", "**/*.bash")
    shfmt("3.10.0")
  }

  json {
    target("**/*.json")
    gson().sortByKeys()
  }

  yaml {
    target("**/*.yaml", "**/*.yml")
    endWithNewline()
    trimTrailingWhitespace()
    jackson()
      .yamlFeature("INDENT_ARRAYS", true)
      .yamlFeature("LITERAL_BLOCK_STYLE", true)
      .yamlFeature("SPLIT_LINES", true)
  }

  java {
    target("**/*.java")
    googleJavaFormat()
    formatAnnotations()
    removeUnusedImports()
  }

  kotlin {
    target("**/*.kt")
    ktfmt().googleStyle()
  }

  kotlinGradle {
    target("**/*.gradle.kts")
    ktfmt().googleStyle()
  }

  sql {
    target("**/*.sql")
    prettier()
  }
}
