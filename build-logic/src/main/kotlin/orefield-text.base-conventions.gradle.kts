/*
 * Copyright 2022 OreField - All Rights Reserved
 */

import org.gradle.kotlin.dsl.jacoco
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    jacoco
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>(name) {
            artifactId = name
            from(components["java"])
        }
    }
}
