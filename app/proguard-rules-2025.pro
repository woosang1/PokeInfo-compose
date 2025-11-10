# 2025년 최신 보안 설정
# ProGuard rules for enhanced security and optimization

# Keep application class
-keep class com.example.PokeInfoApplication { *; }

# Keep all model classes for serialization
-keep class com.example.model.** { *; }

# Keep Retrofit interfaces
-keep interface com.example.**.api.** { *; }

# Keep Room entities
-keep class com.example.database.room.** { *; }

# Keep Hilt generated classes
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }

# Keep Compose classes
-keep class androidx.compose.** { *; }

# 2025년 최신 보안 강화
# Obfuscate class names
-obfuscationdictionary proguard-dictionary.txt
-classobfuscationdictionary proguard-dictionary.txt
-packageobfuscationdictionary proguard-dictionary.txt

# Remove logging in release builds
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

# Remove debug information
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

# 2025년 최신 네트워크 보안
# Keep OkHttp and Retrofit
-keep class okhttp3.** { *; }
-keep class retrofit2.** { *; }

# Keep serialization
-keep class kotlinx.serialization.** { *; }
-keepclassmembers class kotlinx.serialization.** {
    <methods>;
}

# 2025년 최신 성능 최적화
# Remove unused resources
-keep class **.R$* {
    public static <fields>;
}

# Optimize method calls
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5
-allowaccessmodification
-dontpreverify

# 2025년 최신 Kotlin 지원
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }
-dontwarn kotlin.**
-dontwarn kotlinx.**

# Keep coroutines
-keep class kotlinx.coroutines.** { *; }
-keepclassmembers class kotlinx.coroutines.** {
    <methods>;
}
