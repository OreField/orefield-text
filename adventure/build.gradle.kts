plugins {
    id("orefield-text.java-conventions")
}

dependencies {
    api(libs.adventure.api)
    api(project(":orefield-text-api"))
}
