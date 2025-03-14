plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.nicestart"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nicestart"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures{
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}



dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    implementation(libs.lottie);

    implementation (libs.com.squareup.okhttp3.okhttp)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    implementation(libs.glide)
    implementation(libs.glide.transformations)
    implementation(libs.swiperefreshlayout)
    annotationProcessor(libs.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.zxing.android.embedded)

}