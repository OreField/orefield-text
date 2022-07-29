/*
 * Copyright 2022 OreField - All Rights Reserved
 */

import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

val Project.libs
    get() = the<org.gradle.accessors.dm.LibrariesForLibs>()
