cmake_minimum_required(VERSION 3.5)
project(NativeMatrix)

find_package(JNI REQUIRED)

set(JNI_INCLUDE_DIRS "/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/include")
include_directories(${JNI_INCLUDE_DIRS})

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
set(SOURCE_FILES
        Matrix.h
        Matrix.cpp)

# generate libfoo.jnilib
include_directories(${JAVA_INCLUDE_PATH} ${_classDir} ${_stubDir})
add_library(NativeMatrix MODULE Matrix.cpp Matrix.h)
set_target_properties(NativeMatrix PROPERTIES SUFFIX ".jnilib")

# generate executable
add_executable(NativeMatrixExe ${SOURCE_FILES})

# generates a shared libary
add_library(NativeMatrixShared SHARED Matrix.cpp Matrix.h)