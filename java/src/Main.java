

public class Main {

    public static void main(String[] args) {

        long start = 0;
        long end = 0;

        Matrix a = new Matrix(400, 6000);
        Matrix b = new Matrix(6000, 400);

        Matrix c = new Matrix(200, 200);

        // JAVA Section ------------------------------------
        start = System.currentTimeMillis();
        Matrix r1 = a.multiply(b);
        end = System.currentTimeMillis();
        System.out.println("Java Section needed " + (end - start) + " Ms");


        // C++ Section -------------------------------------
        start = System.currentTimeMillis();
        Matrix r2 = a.multiplyNative(b);
        end = System.currentTimeMillis();
        System.out.println("C++ Section needed " + (end - start) + " Ms");


        // Validation --------------------------------------
        System.out.println("Multiply is equal: " + r1.equals(r2));


        System.out.println(" ");
        System.out.println(" ");


        // JAVA Section ------------------------------------
        start = System.currentTimeMillis();
        Matrix r3 = c.power(51);
        end = System.currentTimeMillis();
        System.out.println("Java Section needed " + (end - start) + " Ms");


        // C++ Section -------------------------------------
        start = System.currentTimeMillis();
        Matrix r4 = c.powerNative(51);
        end = System.currentTimeMillis();
        System.out.println("C++ Section needed " + (end - start) + " Ms");


        // Validation --------------------------------------
        System.out.println("Power is equal: " + r1.equals(r2));


    }
}
