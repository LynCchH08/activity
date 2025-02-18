import java.util.Scanner;

class Matrix {
    int[][] date;
    int rows;
    int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        date = new int[rows][columns];
    }

    public void inputValues(Scanner scanner) {
        System.out.println("Enter the data for the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                date[i][j] = scanner.nextInt();
            }
        }
    }

    public int sumRow(int rowIndex) {
        int sum = 0;
        for (int j = 0; j < columns; j++) {
            sum += date[rowIndex][j];
        }
        return sum;
    }

    public int sumColumn(int colIndex) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += date[i][colIndex];
        }
        return sum;
    }

    public void displayMatrix() {
        System.out.println("\nThe 2D array is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(date[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        Matrix matrix = new Matrix(rows, columns);

        matrix.inputValues(scanner);

        matrix.displayMatrix();

        System.out.println("\nSum of rows:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Sum of row " + i + ": " + matrix.sumRow(i));
        }

        System.out.println("\nSum of columns:");
        for (int j = 0; j < columns; j++) {
            System.out.println("Sum of column " + j + ": " + matrix.sumColumn(j));
        }

        scanner.close();
    }
}
