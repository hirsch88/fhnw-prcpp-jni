/**
 * Created by hirsch on 02/05/16.
 */
public class Test {


    static {
        System.setProperty("java.library.path", "/Users/hirsch/Library/Caches/CLion2016.1/cmake/generated/c__-ef8851f0/ef8851f0/Release");
        System.loadLibrary("NativeFunctionsShared");
    }

    public static native void display();

    public static native int increment(int value);

    public static void main(String[] args) {
        Test.display();
        Test.increment(0);
    }

}
