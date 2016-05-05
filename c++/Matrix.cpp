#include <iostream>
#include "Matrix.h"

using namespace std;

int main() {
    return 0;
}

JNIEXPORT void JNICALL Java_Matrix_multiplyC(JNIEnv *jniEnv, jobject,
                                             jdoubleArray a, jdoubleArray b, jdoubleArray r,
                                             jint height, jint width, jint k_val) {

    jboolean *is_copy = new jboolean(false);
    jdouble *ptr_a = jniEnv->GetDoubleArrayElements(a, is_copy);
    jdouble *ptr_b = jniEnv->GetDoubleArrayElements(b, is_copy);
    jdouble *ptr_r = jniEnv->GetDoubleArrayElements(r, is_copy);

    //
    for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
            double val = 0;
            for (int k = 0; k < k_val; ++k) {
                double m1_val = ptr_a[i * k_val + k];
                double m2_val = ptr_b[k * width + j];
                val += m1_val * m2_val;
            }
            ptr_r[i * width + j] = val;
        }
    }
    //

    jniEnv->ReleaseDoubleArrayElements(a, ptr_a, 0);
    jniEnv->ReleaseDoubleArrayElements(b, ptr_b, 0);
    jniEnv->ReleaseDoubleArrayElements(r, ptr_r, 0);

}
