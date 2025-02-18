import java.util.Scanner;

class Matrix {
    private int rows;
    private int columns;
    private double[][] data;

    // Constructor to initialize the matrix
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    // Method to set values in the matrix
    public void setValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the values for the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter value for element [" + i + "][" + j + "]: ");
                data[i][j] = scanner.nextDouble();
            }
        }
    }

    // Method to get the sum of a specific row
    public double sumOfRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < rows) {
            double sum = 0;
            for (int j = 0; j < columns; j++) {
                sum += data[rowIndex][j];
            }
            return sum;
        } else {
            throw new IndexOutOfBoundsException("Row index out of range");
        }
    }

    // Method to get the sum of a specific column
    public double sumOfColumn(int columnIndex) {
        if (columnIndex >= 0 && columnIndex < columns) {
            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += data[i][columnIndex];
            }
            return sum;
        } else {
            throw new IndexOutOfBoundsException("Column index out of range");
        }
    }

    // Getters for rows and columns
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask the user to enter the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Step 2: Create a 2D array of numbers
        Matrix matrix = new Matrix(rows, columns);

        // Step 5: Prompt user to enter array values
        matrix.setValues();

        // Step 3: Get the sum of all rows
        System.out.println("\nSum of each row:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Sum of row " + i + ": " + matrix.sumOfRow(i));
        }

        // Step 4: Get the sum of all columns
        System.out.println("\nSum of each column:");
        for (int j = 0; j < columns; j++) {
            System.out.println("Sum of column " + j + ": " + matrix.sumOfColumn(j));
        }

        scanner.close();
    }
}