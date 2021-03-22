package lab5_2;

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
                System.out.printf("%.0f ", this.data[i][j]);  //.1f for one decimal
            }
            System.out.print("\n");
        }
    }
}
