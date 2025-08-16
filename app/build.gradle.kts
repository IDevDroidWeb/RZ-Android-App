plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.yousefh.rezone"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.yousefh.rezone"
        minSdk = 24
        targetSdk = 35
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    // AndroidX
    implementation(libs.lifecycle.extensions)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.legacy.support.v4)
    implementation(libs.recyclerview)
    implementation(libs.cardview)

    // Google
    implementation(libs.play.services.location)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.messaging)

    // Mapbox
    //implementation(libs.mapbox.android.sdk)
    //implementation(libs.mapbox.android.plugin.annotation.v9)
    //implementation(libs.android.ndk27)
    //implementation("com.mapbox.maps:android:11.14.1")

    // Image Loading
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    // Networking
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    // Other
    implementation(libs.circleimageview)
    implementation(libs.smartmaterialspinner)
    implementation(libs.dotsindicator)
    implementation(libs.pinview)
    implementation(libs.android.gif.drawable)
}