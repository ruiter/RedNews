# Proguard file by Fretebras Android Team
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-dontoptimize
-dontpreverify

-ignorewarnings

-keepattributes *Annotation*

# Keep the originals classes
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

-keepclasseswithmembernames class * {
    native <methods>;
}

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

-dontwarn android.support.**
-dontwarn com.nuance.**
-dontwarn com.millennialmedia.android.**

# gson
-keepattributes Signature
-keepattributes *Annotation*

-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.examples.android.model.** { *; }

-keep public class * extends android.support.v7.widget.RecyclerView$LayoutManager {
    public <init>(...);
}

-dontwarn com.squareup.okhttp.**
-dontwarn retrofit2.**
-dontwarn rx.**
-dontwarn javax.annotation.**
-dontwarn okhttp3.**

-dontwarn org.osmdroid.tileprovider.modules.NetworkAvailabliltyCheck

-keep class com.squareup.okhttp3.** { *; }
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-keep class retrofit2.** { *; }

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform

# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor

# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8

# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature

# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions