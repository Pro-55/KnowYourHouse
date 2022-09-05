plugins {
    apply {
        id("com.android.application")
        kotlin("android")
    }
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.composetest"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.8.0")

    // Compose
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.material3:material3:1.0.0-beta01")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

    // Activity
    implementation("androidx.activity:activity-compose:1.5.1")

    // Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.25.1")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.1")
}