import java.util.Scanner;

public class StudentGradeSystem {

    public static String getGrade(int mark) {
        if (mark >= 90) {
            return "A+";
        } else if (mark >= 80) {
            return "A";
        } else if (mark >= 70) {
            return "B";
        } else if (mark >= 60) {
            return "C";
        } else if (mark >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================");
        System.out.println("     Student Grade System");
        System.out.println("===============================");

        System.out.print("Enter number of students: ");
        int number = scanner.nextInt();

        String[] names = new String[number];
        int[] marks = new int[number];

        int total = 0;
        int highest = 0;
        int lowest = 100;

        int count = 0;

        while (count < number) {

            System.out.println("\nStudent: " + (count + 1));

            System.out.print("Enter name: ");
            String name = scanner.next();

            names[count] = name;

            System.out.print("Enter marks: ");
            int mark = scanner.nextInt();

            marks[count] = mark;

            total += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }

            count++;
        }

        float average = (float) total / number;

        System.out.println("\n========== Results ==========");

        for (int i = 0; i < number; i++) {
            System.out.println(
                    names[i] + " - " +
                    marks[i] + " - " +
                    getGrade(marks[i])
            );
        }

        System.out.println("==============================");
        System.out.println("Class Average: " + average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
        System.out.println("==============================");

        scanner.close();
    }
}
