#C++ JNI

## Create c++ header file from java class
```
// javah -classpath pfadZurClassDatei -d AusgabePfad Test
javah -classpath ./ -d ./../../c++/ Test
```

gcc -I /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/jni.h