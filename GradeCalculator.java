
//  *************************** GRADE CALCULATOR ********************************

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input of how many subjects there are
        System.out.println("Enter the number of subjects:");
        int numOfSubjects = scanner.nextInt();

        // Array to store marks of each subject
        int[] marksArray = new int[numOfSubjects];
        int totalMarks = 0;

        // Taking and adding all the marks
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.println("Enter the marks obtained in subject " + (i + 1) + " (out of 100):");
            marksArray[i] = scanner.nextInt();
            totalMarks += marksArray[i];
        }

        // Calculating Percentage
        double averagePercentage = (double) totalMarks / (numOfSubjects * 100) * 100;

        // Calculating Grade
        String grade = calculateGrade(averagePercentage);

        // Displaying all the Data
        System.out.println("Total marks obtained: " + totalMarks);
        System.out.println("Percentage obtained: " + averagePercentage + "%");
        System.out.println("Grade obtained: " + grade);

        scanner.close();
    }

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C";
        } else if (averagePercentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}
