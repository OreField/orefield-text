/*
 * Copyright 2022 OreField - All Rights Reserved
 */

plugins {
    java
    `java-library`

    id("orefield-text.base-conventions")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation(libs.javaAnnotations)

    testImplementation(platform(libs.test.junit.bom))
    testImplementation(libs.test.junit.api)
    testImplementation(libs.test.junit.engine)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
