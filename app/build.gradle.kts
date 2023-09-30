plugins {
   id("com.android.application")
   id("org.jetbrains.kotlin.android")
}

android {
   namespace = "de.rogallab.mobile"
   compileSdk = 34

   defaultConfig {
      applicationId = "de.rogallab.mobile"
      minSdk = 26
      targetSdk = 34
      versionCode = 1
      versionName = "1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   buildTypes {
      release {
         isMinifyEnabled = false
         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
   }
   kotlinOptions {
      jvmTarget = "17"
   }
   kotlin {
      jvmToolchain(17)
   }
}

dependencies {
   // https://developer.android.com/jetpack/androidx/releases/activity
   val activityVersion = "1.7.2"
   // https://developer.android.com/jetpack/androidx/releases/appcompat
   val appcompatVersion = "1.6.1"
   // https://developer.android.com/jetpack/androidx/releases/constraintlayout
   val constraintlayoutVersion = "2.1.4"
   // https://developer.android.com/jetpack/androidx/releases/core
   val coreVersion = "1.12.0"

   // https://material.io/blog/android-stable-release-1-8-0
   val materialVersion = "1.9.0"

   implementation("androidx.activity:activity-ktx:$activityVersion")
   implementation("androidx.appcompat:appcompat:$appcompatVersion")
   implementation("androidx.constraintlayout:constraintlayout:$constraintlayoutVersion")
   implementation("androidx.core:core-ktx:$coreVersion")
   implementation("com.google.android.material:material:$materialVersion")

   testImplementation("junit:junit:4.13.2")
   androidTestImplementation("androidx.test.ext:junit:1.1.5")
   androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}