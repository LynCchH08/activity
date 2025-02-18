import java.util.Scanner;

class Matrix {
    private int[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public void fillMatrix(Scanner scanner) {
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
    }

    public int sumRow(int rowIndex) {
        int sum = 0;
        for (int j = 0; j < columns; j++) {
            sum += data[rowIndex][j];
        }
        return sum;
    }

    public int sumColumn(int columnIndex) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += data[i][columnIndex];
        }
        return sum;
    }

    public void printSums() {
        System.out.println("Sum of each row:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + i + ": " + sumRow(i));
        }

        System.out.println("Sum of each column:");
        for (int j = 0; j < columns; j++) {
            System.out.println("Column " + j + ": " + sumColumn(j));
        }
    }
}

public class Mainnn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        Matrix matrix = new Matrix(rows, columns);
        matrix.fillMatrix(scanner);
        matrix.printSums();

        scanner.close();
    }
}