/*
 * Copyright 2022 OreField - All Rights Reserved
 */

plugins {
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
