# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 성능 최적화: Kotlin 관련 규칙
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }
-dontwarn kotlin.**
-dontwarn kotlinx.**

# 성능 최적화: Compose 관련 규칙
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# 성능 최적화: Retrofit 관련 규칙
-keep class retrofit2.** { *; }
-dontwarn retrofit2.**
-keepattributes Signature
-keepattributes Exceptions

# 성능 최적화: OkHttp 관련 규칙
-keep class okhttp3.** { *; }
-dontwarn okhttp3.**

# 성능 최적화: Gson 관련 규칙
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

# 성능 최적화: Coil 관련 규칙
-keep class coil.** { *; }
-dontwarn coil.**

# 성능 최적화: Room 관련 규칙
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**

# 성능 최적화: Hilt 관련 규칙
-keep class dagger.hilt.** { *; }
-dontwarn dagger.hilt.**

# 성능 최적화: Paging 관련 규칙
-keep class androidx.paging.** { *; }
-dontwarn androidx.paging.**

# 성능 최적화: Coroutines 관련 규칙
-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.coroutines.**

# 성능 최적화: Serialization 관련 규칙
-keep class kotlinx.serialization.** { *; }
-dontwarn kotlinx.serialization.**

# 성능 최적화: 모델 클래스 보존
-keep class com.example.model.** { *; }

# 성능 최적화: 네트워크 모델 보존
-keep class com.example.network.** { *; }

# 성능 최적화: 데이터베이스 엔티티 보존
-keep class com.example.database.** { *; }

# 성능 최적화: 앱의 주요 클래스 보존
-keep class com.example.pokeinfo.** { *; }