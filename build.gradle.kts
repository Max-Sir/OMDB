buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.7.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.21")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}

plugins {
    id("com.gradle.enterprise") version "3.15.1" apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}
