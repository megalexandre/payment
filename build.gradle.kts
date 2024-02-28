import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
}

group = "payment"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//ULID
	implementation("io.azam.ulidj:ulidj:1.0.4")

	//mockk
	testImplementation("org.mockito:mockito-core")
	testImplementation("io.mockk:mockk:1.12.2")
	testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
	/*


	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("jakarta.validation:jakarta.validation-api")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib")

	implementation("ch.qos.logback:logback-classic")
	implementation("org.slf4j:slf4j-api")



	implementation("com.google.code.gson:gson")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.data:spring-data-mongodb")

	//metrics
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")


	//test
	testImplementation("io.rest-assured:kotlin-extensions")
	testImplementation("org.springframework.boot:spring-boot-starter-test"){
		exclude(module = "junit")
		exclude(module = "mockito-core")
	}
	testImplementation("io.rest-assured:rest-assured")


	testImplementation("org.junit.jupiter:junit-jupiter")


	//teste container
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:testcontainers")
	testImplementation("org.testcontainers:mongodb")

	//teste cubumber
	testImplementation("io.cucumber:cucumber-java:$cumcumber_version")
	testImplementation("io.cucumber:cucumber-java8:$cumcumber_version")
	testImplementation("io.cucumber:cucumber-junit:$cumcumber_version")
	testImplementation("io.cucumber:cucumber-spring:$cumcumber_version")
	* */

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
