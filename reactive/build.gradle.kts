group = "studio.thinkground.aroundhub.reactive"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

spotless {
    format("yaml") {
        target("**.*.yaml", "**/*.yml")
        prettier().configFile("${rootDir}/.prettierrc")
    }
    java {
        removeUnusedImports()
        googleJavaFormat()
        importOrder(
            "java",
            "jakarta",
            "lombok",
            "org.springframework",
            "",
            "\\#",
            "studio.thinkground",
            "\\#studio.thinkground"
        )
        indentWithTabs(2)
        indentWithSpaces(2)
        trimTrailingWhitespace()
        endWithNewline()
    }
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    systemProperties["spring.profiles.active"] = "test"
}