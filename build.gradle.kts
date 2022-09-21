buildscript {
    dependencies {
        classpath(Plugins.hiltGradlePlugin)
    }
}

plugins {
    id("com.android.application") version "7.3.0" apply false
    id("com.android.library") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlin apply false
}