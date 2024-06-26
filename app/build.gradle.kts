import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin.Companion.isIncludeCompileClasspath

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.serialization)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.kapt)
//    alias(libs.plugins.google.ksp)
    alias(libs.plugins.room)
//    alias(libs.plugins.google.services)
}

android {
    namespace = "com.example.fetchrewards"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fetchrewards"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
//    ksp {
//        arg("room.schemaLocation", "$projectDir/schemas")
//    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
//    sqldelight {
//        databases {
//            create("FetchRewards") {
//                packageName.set("com.example.fetchrewards")
//            }
//        }
//    }
}

dependencies {
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.compose.junit)
    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.hilt.android.testing)
    kapt(libs.hilt.android.compiler)
    kapt(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.compiler)
    androidTestImplementation(libs.junit.test.extensions)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.compose.bom))
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.debug.compose.foundation)
    debugImplementation(libs.debug.compose.tooling)
    debugImplementation(libs.debug.compose.ui.test)
    implementation(libs.accompanist.permissions)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.hilt.navigation)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.coil.compose)
    implementation(libs.compose.activity)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.material3)
    implementation(libs.compose.navigation)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling)
    implementation(libs.hilt.android)
    implementation(libs.junit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.viewmodel.savedstate)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit)
//    implementation(libs.retrofit.moshi)
    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.coroutines)
    implementation(platform(libs.androidx.compose.bom))
    implementation(platform(libs.compose.bom))
    implementation(platform(libs.okhttp.bom))
    testImplementation(libs.core.testing)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    implementation(libs.kotlin.std)
    implementation(libs.retrofit.gson)
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)

}