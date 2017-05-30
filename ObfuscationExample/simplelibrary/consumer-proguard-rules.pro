# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/finik/work/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

##---------------Begin: settings, recommended for libraries (https://www.guardsquare.com/en/proguard/manual/examples#library):  ----------
-keepparameternames
-renamesourcefileattribute SourceFile
-keepattributes Exceptions, InnerClasses, Signature, Deprecated, SourceFile, LineNumberTable, *Annotation*, EnclosingMethod

# Preserve all native method names and the names of their classes.
-keepclasseswithmembernames, includedescriptorclasses class * {
    native <methods>;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
##---------------End: settings, recommended for libraries  ----------

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------End: proguard configuration for Gson  ----------

##---------------Begin: custom library settings  ----------
# Keep all classes from "data" subfolder (and nested subfolders), because they can be serialized/deserialized.
-keep class com.bugsee.shared.simplelibrary.data.DataClass { *; }
-keep class com.bugsee.shared.simplelibrary.data.DataClass$Type { *; }
##---------------End: custom library settings  ----------