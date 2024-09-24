plugins {
    id("java")
}

group = "com.marsrover"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Google Guice for dependency injection
    implementation("com.google.inject:guice:5.1.0")  // Add this dependency

    // JUnit 5 for testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    // Mockito for mocking
    testImplementation("org.mockito:mockito-core:5.3.1")
    testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
