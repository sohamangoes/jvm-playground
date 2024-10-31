plugins {
  id("com.diffplug.spotless") version ("6.25.0")
  id("jacoco-report-aggregation")
}

repositories { gradlePluginPortal() }

dependencies {
  jacocoAggregation(project(":packages:libraries:hello-world"))
  jacocoAggregation(project(":packages:libraries:leetcode"))
}

spotless {
  protobuf { buf() }

  shell {
    target("**/*.sh", "**/*.bash")
    shfmt("3.10.0")
  }

  json {
    target("**/*.json")
    targetExclude("**/build/**")
    gson().sortByKeys()
  }

  yaml {
    target("**/*.yaml", "**/*.yml")
    targetExclude("**/build/**")
    endWithNewline()
    trimTrailingWhitespace()
    jackson().yamlFeature("LITERAL_BLOCK_STYLE", true).yamlFeature("SPLIT_LINES", true)
  }

  java {
    target("**/*.java")
    targetExclude("**/build/**")
    googleJavaFormat()
    formatAnnotations()
    removeUnusedImports()
  }

  kotlin {
    target("**/*.kt")
    targetExclude("**/build/**")
    ktfmt().googleStyle()
  }

  kotlinGradle {
    target("**/*.gradle.kts")
    targetExclude("**/build/**")
    ktfmt().googleStyle()
  }

  sql {
    target("**/*.sql")
    prettier()
  }
}

reporting {
  reports {
    val testCodeCoverageReport by
      creating(JacocoCoverageReport::class) { testType = TestSuiteType.UNIT_TEST }
  }
}

task("addGitPreCommitHook") {
  println("⚈ ⚈ ⚈ Running Add Pre Commit Git Hook Script on Build ⚈ ⚈ ⚈")
  exec { commandLine("cp", "./.scripts/git-hooks/pre-commit", "./.git/hooks") }
  println("✅ Added Pre Commit Git Hook Script")
}
