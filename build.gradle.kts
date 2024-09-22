plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // JUnit for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

application {
    // main class
    mainClass.set("StartMain")
}

tasks.test {
    useJUnitPlatform() //  JUnit
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // Use Java 17
    }
}
