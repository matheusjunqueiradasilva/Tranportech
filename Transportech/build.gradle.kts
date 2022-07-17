import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"


}

group = "com.TransporTech"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()


}

dependencies {
	developmentOnly("org.springframework.boot:spring-boot-devtools:2.7.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.0")
	implementation("org.springframework.boot:spring-boot-starter-web:2.7.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.0")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.0")
	runtimeOnly("com.h2database:h2:2.1.212")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.0")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.7.0")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
tasks.withType<Test> {
	useJUnitPlatform()
}

