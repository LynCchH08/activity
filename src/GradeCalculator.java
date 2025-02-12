import java.io.*;
import java.util.Scanner;

public class GradeCalculator {

    public static final double MIN_GRADE = 50;
    public static final String FILE_DIRECTORY = "target/student_records";
    public static final int MAX_SUBJECTS = 64;
    public static final int NUM_TERMS = 3;

    public static void main(String[] args) {
        String studentName;
        String subjectName;

        String[] subjects = new String[MAX_SUBJECTS];
        double[][] grades = new double[MAX_SUBJECTS][NUM_TERMS];

        String[] terms = {"Prelim", "Midterm", "Finals"};

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        studentName = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        result.append("Student: ").append(studentName);

        result.append("\n").append(String.format(
                        "%-20s%-10s%-10s%-10s%-15s\n",
                        "Subject", "Prelim", "Midterm", "Final", "Final Rating"
                )
        );

        for (int i = 0; i < MAX_SUBJECTS; i++) {
            System.out.print("Enter subject name: ");
            subjectName = scanner.nextLine();
            subjects[i] = subjectName;
            result.append(String.format("%-20s", subjects[i]));


            for (int j = 0; j < NUM_TERMS; j++) {
                System.out.print("\tEnter " + terms[j] + " grade: ");
                try {
                    grades[i][j] = Double.parseDouble(scanner.nextLine());
                    if (grades[i][j] < MIN_GRADE) {
                        throw new Exception("Error! Grades cannot be less than 50.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\tError! Invalid number format.");
                    --j;
                    continue;
                } catch (Exception e) {
                    System.out.println("\t" + e.getMessage());
                    --j;
                    continue;
                }


                result.append(String.format("%-10.2f", grades[i][j]));
            }


            result.append(String.format("%.2f\n", calculateFinalRating(grades[i])));


            System.out.print("Add another subject? (y/n): ");
            char userChoice = scanner.nextLine().charAt(0);

            if (Character.toLowerCase(userChoice) != 'y') {
                break;
            }
        }


        System.out.println(result);
        saveResultsToFile(studentName, result.toString());
    }


    public static double calculateFinalRating(double[] termGrades) {
        return termGrades[0] * 0.3 + termGrades[1] * 0.3 + termGrades[2] * 0.4;
    }

    public static void saveResultsToFile(String studentName, String data) {
        File directory = new File(FILE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, studentName + "_grades.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(data);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void readAllGradeFiles() {
        File directory = new File(FILE_DIRECTORY);
        File[] gradeFiles = directory.listFiles();
        for (File gradeFile : gradeFiles) {
            if (gradeFile.isFile()) {
                readFile(gradeFile);
            }
        }
    }

    public static void readFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            System.out.println("--------------------------");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
