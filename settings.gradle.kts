/*
 * Copyright 2022 OreField - All Rights Reserved
 */

rootProject.name = "orefield-text"

dependencyResolutionManagement {
    includeBuild("build-logic")
}

sequenceOf(
    "adventure"
).forEach {
    include(it)
    project(":$it").name = "${rootProject.name}-$it"
}
