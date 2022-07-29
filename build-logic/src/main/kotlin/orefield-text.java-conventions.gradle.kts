/*
 * Copyright 2022 OreField - All Rights Reserved
 */

import gradle.kotlin.dsl.accessors._3018ba51e2fe77536ad2914c7cacf0d3.implementation
import gradle.kotlin.dsl.accessors._3018ba51e2fe77536ad2914c7cacf0d3.java
import gradle.kotlin.dsl.accessors._3018ba51e2fe77536ad2914c7cacf0d3.testImplementation

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
