plugins {
    id("java")
}

group = "com.marsrover"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Explicitly override the vulnerable Guava version
    implementation("com.google.guava:guava:32.0.0-android") // Updated to a secure version of Guava

    // JUnit 5 for testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // Mockito for mocking
    testImplementation("org.mockito:mockito-core:5.5.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.5.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}