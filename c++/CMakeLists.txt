cmake_minimum_required(VERSION 3.5)
project(NativeFunctions)

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})
set(JNI_INCLUDE_DIRS "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/jni.h")

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
        main.cpp
        Test.h)

add_library(NativeFunctionsShared SHARED main.cpp Test.h)
add_library(NativeFunctionsStatic STATIC main.cpp Test.h)
add_library(NativeFunctionsModule MODULE main.cpp Test.h)
add_executable(NativeFunctionsExecutable ${SOURCE_FILES})
