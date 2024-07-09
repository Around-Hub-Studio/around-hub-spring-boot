group = "studio.thinkground.aroundhub.mvc"
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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.4.0")

    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

    implementation("org.mariadb.jdbc:mariadb-java-client")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    systemProperties["spring.profiles.active"] = "test"
}