plugins {
    java
}

repositories {
    mavenCentral()
}

java {
    version = JavaVersion.VERSION_17
}

val cucumberRuntime by configurations.creating {
    extendsFrom(configurations.testImplementation.get())
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.cucumber:cucumber-java:7.0.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.0.0")
    testImplementation("org.junit.platform:junit-platform-suite:1.8.1")
}

tasks.create<JavaExec>("cucumber",) {
    description = "Runs the Cucumber test scenario's"
    dependsOn("assemble", "testClasses")

    mainClass.set("io.cucumber.core.cli.Main")
    classpath(configurations["cucumberRuntime"], sourceSets["main"].output, sourceSets["test"].output)
    args(
        "--plugin", "html:build/cucumber-reports/test-report.html",
        "--plugin", "pretty",
        "--glue", "hello.cucumber", "src/test/resources"
    )

}

tasks.create<JavaExec>("cucumber-help") {
    description = "Show the Cucumber command line help"
    mainClass.set("io.cucumber.core.cli.Main")
    classpath(configurations["cucumberRuntime"])
    args("--help")
}

tasks.create<JavaExec>("cucumber-version") {
    description = "Show the version of Cucumber used int the project"
    mainClass.set("io.cucumber.core.cli.Main")
    classpath(configurations["cucumberRuntime"])
    args("--version")
}