#include <iostream>
#include "Test.h"

using namespace std;

int main() {
//    cout << "Hello, World!" << endl;
    return 0;
}

JNIEXPORT void JNICALL Java_main_1Tutorial_display(JNIEnv *, jclass) {
    std::cout << "C++: Hello world!\n";
}

JNIEXPORT jint JNICALL Java_main_1Tutorial_increment(JNIEnv *, jclass, jint i) {
    std::cout << "C++:incrementing value" << std::endl;
    return ++i;
}
