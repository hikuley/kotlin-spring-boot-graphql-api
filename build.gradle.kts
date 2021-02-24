import com.netflix.graphql.dgs.codegen.gradle.GenerateJavaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
    id("com.netflix.dgs.codegen") version "4.0.12"
}

group = "com.kuleysoft"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter:3.0.10")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}

@OptIn(ExperimentalStdlibApi::class)
tasks.withType<GenerateJavaTask> {
    language = "KOTLIN"
    schemaPaths = mutableListOf("${projectDir}/src/main/resources/schema") // List of directories containing schema files
    packageName = "com.kuleysoft.generated" // The package name to use to generate sources
}