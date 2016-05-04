

public class Main {

    public static void main(String[] args) {

//        Test t1 = new Test();
//        t1.display();
//
//        System.out.println("Hello World!");

        Matrix m1 = new Matrix(4, 5);
        Matrix m2 = new Matrix(5, 6);
        System.out.println(m1.amountRows);
        System.out.println(m1.amountCols);

        Matrix m3 = m1.multiply(m2);
        System.out.println(m3.amountRows);
        System.out.println(m3.amountCols);


    }
}
