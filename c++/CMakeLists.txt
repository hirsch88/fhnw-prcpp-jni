cmake_minimum_required(VERSION 3.5)
project(jni)

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

if(JNI_FOUND)
    message (STATUS "JAVA_INCLUDE_PATH2=${JAVA_INCLUDE_PATH2}")
else()
    message (FATAL_ERROR "I really need JNI like it's 1999.")
endif()

set(JNI_INCLUDE_DIRS "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/jni.h")

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
        main.cpp
        Test.h)

add_executable(jni ${SOURCE_FILES})
