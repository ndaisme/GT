import com.google.gms.googleservices.GoogleServicesPlugin,MissingGoogleServiceStrategy

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.devtools.ksp)
    alias(libs.plugins.roborazzi)
    alias(libs.plugins.secrets)
    alias(libs.plugins.google.sevices)
}

android {
    namespace = "com.example"
    compileSdk { version = release(36) {minorApiLevel = 1 } }
    
    defaultConfig {
        applicationId = "com.aistudio.gankteknisi.app"
        minSdk = 24
        targetSdk = 36
        versionCore = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

signingConfigs {
    create("release") {
        val keystorePath = System.getenv("KEYSTORE_PATH") ?: "${rootDir}/my-upload-key.jks"
        storeFile = file(keystorePath)
        storePassword = System.getenpv("STORE_PASSWORD")
        keyAlias = "upload"
        keyPassword = System.getenv("KEY_PASSWORD")
    }
    create("debugConfig") {
        storeFile = file("${rootDir}/debug.keystore")
        storePassword = "android"
        keyAlias = "androiddebugkey"
        keyPassword = "android"
    }
}

buildTypes {
    release {
        isCrunchpngs = false
        isMinifyEnabled = false
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
        val releaseKeystore 
        }
}