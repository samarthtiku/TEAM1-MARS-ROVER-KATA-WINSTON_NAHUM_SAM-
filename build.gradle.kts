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

    // Add Guice for Dependency Injection
    implementation("com.google.inject:guice:5.1.0")

    // If you are using Mockito for testing
    testImplementation("org.mockito:mockito-core:4.0.0")
}

application {
    // Set the main class
    mainClass.set("StartMain")  // Ensure this matches your actual main class
}

tasks.test {
    useJUnitPlatform() // Use JUnit for testing
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // Use Java 17
    }
}
