import java.util.Scanner;

public class gradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStud = 3;
        int numSubj = 4;

        int[][] grades = new int[numStud][numSubj];

        System.out.println("Enter Grades for " + numStud + " students and " + numSubj + " subjects.");
        for (int i = 0; i < numStud; i++) {
            System.out.println("Enter Grades for Student " + (i + 1) + ":");
            for (int j = 0; j < numSubj; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                grades[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nAverage Grades of Each Student:");
        for (int i = 0; i < numStud; i++) {
            int total = 0;
            for (int j = 0; j < numSubj; j++) {
                total += grades[i][j];
            }
            double average = (double) total / numSubj;
            System.out.println("Student " + (i + 1) + ": " + average);
        }

        System.out.println("\nAverage Grades of Each Subject:");
        for (int j = 0; j < numSubj; j++) {
            int total = 0;
            for (int i = 0; i < numStud; i++) {
                total += grades[i][j];
            }
            double average = (double) total / numStud;
            System.out.println("Subject " + (j + 1) + ": " + average);
        }
    }
}
