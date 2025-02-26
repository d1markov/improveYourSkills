plugins {
    kotlin("jvm")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation( "io.github.java-diff-utils:java-diff-utils:4.12")
}

tasks.test {
    useJUnitPlatform()
}