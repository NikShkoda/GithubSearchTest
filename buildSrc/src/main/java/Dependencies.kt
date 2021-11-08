object ApplicationId {
    val id = "com.rnc.ns.githubsearch"
}

object Modules {
    val presentation = "::presentation"
    val data = "::data"
    val domain = "::domain"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val compileSdk = 31
    val targetSdk = 31
    val minSdk = 23
    val flow = "1.5.2"
    val hilt = "2.38.1"
    val okHttp = "4.9.1"
    val retrofit = "2.9.0"
    val lifecycle = "2.4.0"
    val paging = "3.0.1"
    val navigation = "2.3.5"
    val glide = "4.12.0"
    val coreKtx = "1.7.0"
    val appCompat = "1.3.1"
    val material =  "1.4.0"
    val junit = "4.1.2"
    val junitExt = "1.1.3"
    val espressoCore = "3.4.0"
}

object Libraries {
    // Dependency Injection
    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Async work
    val flow = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.flow}"

    // Network
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object AndroidLibraries {
    // Core
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val material = "com.google.android.material:material:${Versions.material}"

    // Paging
    val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"

    // Navigation
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Image loading
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler${Versions.glide}"

    // Lifecycle
    val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}