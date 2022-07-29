/*
 * Copyright 2022 OreField - All Rights Reserved
 */

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
