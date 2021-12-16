object Dependencies {

    object Compose {
        const val version = "1.0.1"
        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"

        const val toolingTest = "androidx.compose.ui:ui-tooling:$version"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"

        const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val hiltFragment = "androidx.hilt:hilt-navigation-fragment:1.0.0"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
        const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha04"

    }

    object Kotlin {
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"
        const val coilKt = "io.coil-kt:coil:1.2.2"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.2"
    }

    object Hilt {
        const val version = "2.38.1"
        const val android = "com.google.dagger:hilt-android:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Room {
        private const val version = "2.3.0"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:2.4.0-alpha04"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Navigation {
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-alpha10"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
    }

    object Lifecycle {
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    }

    object Test {
        const val jUnit = "junit:junit:4.+"
        const val androidJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object OkHttp {
        const val okHttp_version = "4.8.0"

        const val okHttp = "com.squareup.okhttp3:okhttp:$okHttp_version"
        const val okHttpLogging  = "com.squareup.okhttp3:logging-interceptor:$okHttp_version"
    }

    object Retrofit {
        const val retrofit_version = "2.4.0"

        const val retrofit =  "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val retrofitConverter = "com.squareup.retrofit2:converter-gson:$retrofit_version"
        const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"
    }

    object Swipe {
        const val swipe =  "com.google.accompanist:accompanist-swiperefresh:0.19.0"
    }

    object Video {
        const val video =  "com.google.android.exoplayer:exoplayer:2.16.1"

    }

    object Maps {
        const val mapsServices =  "com.google.android.gms:play-services-maps:18.0.0"
        const val maps = "com.google.android.libraries.maps:maps:3.1.0-beta"
        const val mapsKtx = "com.google.maps.android:maps-v3-ktx:2.2.0"
        const val mapsFragment = "androidx.fragment:fragment-ktx:1.4.0"
    }

    object RxJava {
        const val rxJavaAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
    }

    object Pager {
        const val pager =  "com.google.accompanist:accompanist-pager:0.14.0"
        const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:0.14.0"
    }

    object Firebase {
        const val servicesAuth =  "com.google.android.gms:play-services-auth:19.2.0"
        const val servicesAds = "com.google.android.gms:play-services-ads:20.5.0"
        const val FirebaseAuth = "com.google.firebase:firebase-auth:21.0.1"
        const val FirebaseBom = "com.google.firebase:firebase-bom:29.0.0"
    }
}