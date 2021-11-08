object ApplicationId {
    const val id = "com.rnc.ns.githubsearch"
}

object Modules {
    const val presentation = "::presentation"
    const val data = "::data"
    const val domain = "::domain"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val compileSdk = 31
    const val targetSdk = 31
    const val minSdk = 23
    const val flow = "1.5.2"
    const val hilt = "2.38.1"
    const val okHttp = "4.9.1"
    const val retrofit = "2.9.0"
    const val lifecycle = "2.4.0"
    const val paging = "3.0.1"
    const val navigation = "2.3.5"
    const val glide = "4.12.0"
    const val coreKtx = "1.7.0"
    const val appCompat = "1.3.1"
    const val material =  "1.4.0"
    const val junit = "4.1.2"
    const val junitExt = "1.1.3"
    const val espressoCore = "3.4.0"
}

object Libraries {
    // Dependency Injection
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Async work
    const val flow = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.flow}"

    // Network
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object AndroidLibraries {
    // Core
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"

    // Paging
    const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"

    // Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Image loading
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler${Versions.glide}"

    // Lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}