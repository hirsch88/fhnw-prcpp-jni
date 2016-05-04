cmake_minimum_required(VERSION 3.5)
project(NativeFunctions)

find_package(JNI REQUIRED)

set(JNI_INCLUDE_DIRS "/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/include")
include_directories(${JNI_INCLUDE_DIRS})

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
set(SOURCE_FILES
        main.cpp
        Test.h)

# generate libfoo.jnilib
include_directories(${JAVA_INCLUDE_PATH} ${_classDir} ${_stubDir})
add_library(NativeFunctions MODULE main.cpp Test.h)
set_target_properties(NativeFunctions PROPERTIES SUFFIX ".jnilib")

# generate executable
add_executable(NativeFunctionsExe ${SOURCE_FILES})

# generates a shared libary
add_library(NativeFunctionsShared SHARED main.cpp Test.h)