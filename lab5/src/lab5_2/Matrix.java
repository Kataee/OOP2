package lab5_2;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];

    }

    //ez mi lenne és hogy hívóik meg?
    public Matrix(double[][] data) {
        this.columns = data[0].length;
        this.rows = data.length;
        this.data = new double[rows][columns];

        for (int i=0; i<this.rows; ++i) {
            for (int j=0; j< this.columns; ++j) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    public Matrix(Matrix asd) {
        this.rows = asd.getRows();
        this.columns = asd.getColumns();
        this.data = new double[rows][columns];

        for (int i=0; i<this.rows; ++i) {
            for (int j=0; j< this.columns; ++j) {
                this.data[i][j] = asd.data[i][j];
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void printMatrix() {
        for (int i=0; i<this.rows; ++i) {
            for (int j=0; j< this.columns; ++j) {
                System.out.printf("%.1f ", this.data[i][j]);  //.1f for one decimal
            }
            System.out.print("\n");
        }
    }

    public void fillRandom(double min, double max) {
        Random rand = new Random();
        double random;
        for (int i=0; i<this.rows; ++i) {
            for (int j=0; j< this.columns; ++j) {
                //this.data[i][j] = (Math.random() * ((max - min) + 1)) + min; //this goes between 1-3 for input 1-2
                this.data[i][j] = ThreadLocalRandom.current().nextDouble(min, max);

            }
        }
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        Matrix zxc = new Matrix(m1.getRows(), m1.getColumns());
        //non static method add cannot be referenced from a static context    //// ?????
        /*for (int i=0; i<this.rows; ++i) {
            for (int j=0; j< this.columns; ++j) {
                zxc.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }

         */
        for (int i=0; i < m1.getRows(); ++i) {
            for (int j=0; j < m1.getColumns(); ++j) {
                zxc.data[i][j] = m1.data[i][j] + m2.data[i][j];
                //System.out.printf("%d %d\n", i, j);
            }
        }
        return zxc;
    }

}
