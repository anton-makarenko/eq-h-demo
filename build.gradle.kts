plugins {
    id("java")
    id("io.spring.dependency-management") version "1.1.0"
    id("org.springframework.boot") version "3.1.0"
}

val springBootVersion = "3.1.0"
val lombokVersion = "1.18.28"
val dbDriverVersion = "42.6.0"

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-parent:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.postgresql:postgresql:$dbDriverVersion")

    compileOnly("org.projectlombok:lombok:$lombokVersion")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}

tasks.test {
    useJUnitPlatform()
}