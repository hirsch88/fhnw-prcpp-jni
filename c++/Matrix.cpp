#include <iostream>
#include "Matrix.h"

using namespace std;

int main() {
    return 0;
}

void doMultiply(jdouble *ptr_a, jdouble *ptr_b, jdouble *ptr_r, jint height, jint width, jint k_val) {
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
}

JNIEXPORT void JNICALL Java_Matrix_multiplyC(JNIEnv *jniEnv, jobject,
                                             jdoubleArray a, jdoubleArray b, jdoubleArray r,
                                             jint height, jint width, jint k_val) {

    jboolean *is_copy = new jboolean(false);
    jdouble *ptr_a = jniEnv->GetDoubleArrayElements(a, is_copy);
    jdouble *ptr_b = jniEnv->GetDoubleArrayElements(b, is_copy);
    jdouble *ptr_r = jniEnv->GetDoubleArrayElements(r, is_copy);

    //
    doMultiply(ptr_a, ptr_b, ptr_r, height, width, k_val);
    //

    jniEnv->ReleaseDoubleArrayElements(a, ptr_a, 0);
    jniEnv->ReleaseDoubleArrayElements(b, ptr_b, 0);
    jniEnv->ReleaseDoubleArrayElements(r, ptr_r, 0);

}

JNIEXPORT void JNICALL Java_Matrix_powerC(JNIEnv *jniEnv, jobject, jint k, jdoubleArray val, jdoubleArray r,
                                          jint height) {

    jboolean *is_copy = new jboolean(false);
    jdouble *ptr_a = jniEnv->GetDoubleArrayElements(val, is_copy);
    jdouble *ptr_r = jniEnv->GetDoubleArrayElements(r, is_copy);

    //
    for (int i = 0; i < height * height; i++) {
        ptr_r[i] = ptr_a[i];
    }


    for (int i = 1; i < k; i++) {
        jdouble *ptr_tmp = new jdouble[height * height];
        doMultiply(ptr_r, ptr_a, ptr_tmp, height, height, height);

        for (int j = 0; j < height * height; j++) {
            ptr_r[j] = ptr_tmp[j];
        }
    }
    //

    jniEnv->ReleaseDoubleArrayElements(val, ptr_a, 0);
    jniEnv->ReleaseDoubleArrayElements(r, ptr_r, 0);


}
