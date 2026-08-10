import java.util.Scanner;

public class Calculator {

    public static int add(int a, int b){
        return a+b;
    }

    public static int subtract(int a, int b){
        return a - b;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static int divide(int a, int b){
        if(b == 0){
            System.out.println("Cannot divide by 0");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.print("Enter your first number: ");
            int a = scanner.nextInt();
            System.out.print("Enter your second number: ");
            int b = scanner.nextInt();
            System.out.println("-------------------------");
            System.out.println("Enter your choice:");
            System.out.println("-------------------------");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your answer for " + a + " and " + b + " is: " + add(a, b));
                    continue;

                case 2:
                    System.out.println("Your answer for " + a + " and " + b + " is: " + subtract(a, b));
                    continue;

                case 3:
                    System.out.println("Your answer for " + a + " and " + b + " is: " + multiply(a, b));
                    continue;
                
                case 4:
                    System.out.println("Your answer for " + a + " and " + b + " is: " + divide(a, b));
                    continue;

                case 5:
                    scanner.close();
                    return;
            
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }
        }
    }
}
