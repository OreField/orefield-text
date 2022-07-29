/*
 * Copyright 2022 OreField - All Rights Reserved
 */

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(files(libs::class.java.superclass.protectionDomain.codeSource.location))
}
