plugins {
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("io.micronaut.application") version "1.5.4"
    id("com.google.cloud.tools.jib") version "2.8.0"
}

version = "0.1"
group = "com.delta"

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.delta.*")
    }
}

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("io.micronaut.openapi:micronaut-openapi")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.elasticsearch:micronaut-elasticsearch")
    implementation("io.micronaut.kafka:micronaut-kafka")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("javax.annotation:javax.annotation-api")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("ch.qos.logback:logback-classic")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:testcontainers")
    implementation("io.micronaut:micronaut-validation")

}


application {
    mainClass.set("com.delta.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("16")
    targetCompatibility = JavaVersion.toVersion("16")
}



jib {
    to {
        image = "gcr.io/myapp/jib-image"
    }
}
