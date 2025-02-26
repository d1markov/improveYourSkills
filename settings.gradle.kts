pluginManagement {
    repositories {
        maven { setUrl("https://nexus.tcsbank.ru/repository/gradle-plugins/") }
       // mavenLocal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        // Use Maven Central for resolving dependencies.
        maven { setUrl("https://nexus.tcsbank.ru/repository/mvn-maven-proxy/") }
    }
}
include("files")
include ("kotlin-interview")
//include ("kotlin-code-parcer")
include("leetcode")
include("kotlin-various-things")
include("stringDiffs")
