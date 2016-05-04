/**
 * Created by hirsch on 04/05/16.
 */

import java.util.Arrays;
import java.util.Random;

public class Matrix {

    public final int MAX_DEFAULT_VALUE = 2;

    public double[] values;
    public int amountRows = 0;
    public int amountCols = 0;
    public int defaultValue = MAX_DEFAULT_VALUE + 1;

    Matrix(int amountRows, int amountCols) {
        this.amountRows = amountRows;
        this.amountCols = amountCols;
        this.values = new double[this.getSize()];

    }

    Matrix(int amountRows, int amountCols, int defaultValue) {
        this(amountRows, amountCols);
        this.defaultValue = defaultValue;
    }

    Matrix multiply(Matrix m) {
        this.validate(m);
        Matrix result = new Matrix(this.amountRows, m.amountCols);

        for (int i = 0; i < this.amountRows; i++) {
            for (int j = 0; j < this.amountRows; j++) {
                double val = 0;
                for (int k = 0; k < this.amountCols; k++) { // spalten matrix 1,
                    // zeilen matrix 2
                    double m1Val = this.values[i * this.amountCols + k];
                    double m2Val = m.values[k * m.amountCols + j];
                    val += m1Val * m2Val;
                }
                result.values[i * m.amountCols + j] = val;
            }
        }

        return result;
    }

    boolean equals(Matrix m) {
        return Arrays.equals(this.values, m.values);
    }

    private boolean validate(Matrix m) {
        if (this.amountCols == m.amountRows) {
            return true;
        } else {
            throw new IllegalArgumentException("Matrix A must have the same width like the height of Matrix B");
        }
    }

    private void fill() {
        for (int i = 0; i < this.getSize(); i++) {
            values[i] = this.getValue();
        }
    }

    private int getSize() {
        return this.amountRows * this.amountCols;
    }

    private int getValue() {
        if (this.defaultValue > MAX_DEFAULT_VALUE) {
            Random random = new Random();
            return random.nextInt(MAX_DEFAULT_VALUE);
        } else {
            return this.defaultValue;
        }
    }

}
