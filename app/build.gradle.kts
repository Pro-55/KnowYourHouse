plugins {
    apply {
        id("com.android.application")
        kotlin("android")
        kotlin("kapt")
        id("dagger.hilt.android.plugin")
    }
}

android {
    namespace = "com.example.knowyourhouse"
    compileSdk = 33
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
    defaultConfig {
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.10.0")

    // Compose
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3:1.1.0-rc01")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Activity
    implementation("androidx.activity:activity-compose:1.7.1")

    // Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.25.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-compiler:2.43.2")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}