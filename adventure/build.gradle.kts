/*
 * Copyright 2022 OreField - All Rights Reserved
 */

plugins {
    id("orefield-text.java-conventions")
}

dependencies {
    api(libs.adventure.api)
    api(project(":orefield-text-common"))
}
