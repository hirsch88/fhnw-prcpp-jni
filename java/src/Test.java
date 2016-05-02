/**
 * Created by hirsch on 02/05/16.
 */
public class Test {


    static {
        System.loadLibrary("NativeFunctions");
    }

    public static native void display();

    public static native int increment(int value);

    public static void main(String[] args) {
        Test.display();
        Test.increment(0);
    }

}
