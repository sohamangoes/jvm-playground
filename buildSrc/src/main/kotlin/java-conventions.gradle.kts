plugins {
  java
  jacoco
}

repositories {
  mavenCentral()
  gradlePluginPortal()
}

java { toolchain { languageVersion.set(JavaLanguageVersion.of(21)) } }

group = "com.github.sohamangoes"

dependencies {
  compileOnly("org.projectlombok:lombok:1.18.34")
  annotationProcessor("org.projectlombok:lombok:1.18.34")

  testCompileOnly("org.projectlombok:lombok:1.18.34")
  testAnnotationProcessor("org.projectlombok:lombok:1.18.34")

  testImplementation(platform("org.junit:junit-bom:5.11.3"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")

  testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
  useJUnitPlatform()
  testLogging { events("passed", "skipped", "failed") }
  finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport { dependsOn(tasks.test) }
