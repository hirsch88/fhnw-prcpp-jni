#C++ JNI

## Create c++ header file from java class
```
// javah -classpath pfadZurClassDatei -d AusgabePfad Test
javah -classpath ./ -d ./../../c++/ Test
```

gcc -I /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/jni.h

```
g++ -dynamiclib -flat_namespace -Wl,--add-stdcall-alias -I/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/include -shared -o ./../java/libNativeFunctions.so main.cpp Test.h

 

```
