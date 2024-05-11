plugins {
    kotlin("jvm") version "1.9.24"
    id("maven-publish")
}

group = "com.github.sun5066"
version = "1.0.2"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.24-1.0.20")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
