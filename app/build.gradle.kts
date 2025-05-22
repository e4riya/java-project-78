plugins {
    checkstyle
    application
    jacoco
    id ("com.github.ben-manes.versions") version "0.38.0"
    id ("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass = "hexlet.code.App"
}

repositories {
    mavenCentral()
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }


sonar {
    properties {
        property ("sonar.projectKey", "e4riya_java-project-78")
        property ("sonar.organization", "e4riya")
        property ("sonar.host.url", "https://sonarcloud.io")
    }
}