plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.geminidemo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.geminidemo"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.activity.ktx)
    implementation("com.github.envy2sultanawaischeema-design:ChatWithGiminiBypass:master-SNAPSHOT")
    // ★ ChatWithGiminiBypass library
//    implementation("com.github.envy2sultanawaischeema-design:ChatWithGiminiBypass:v2.0.1")
}
