import java.util.Scanner;

public class SimpleATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000.0;
        int choice;

        while (true) {
            System.out.println("============================");
            System.out.println("        SIMPLE ATM");
            System.out.println("============================");

            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter the amount you wish to deposit: ");
                    double deposit = scanner.nextDouble();

                    if (deposit <= 0) {
                        System.out.println("Invalid deposit amount!");
                        System.out.println("Deposit amount must be greater than 0.");
                    } else {
                        balance += deposit;
                        System.out.println("₹" + deposit + " deposited successfully.");
                        System.out.println("New Balance: ₹" + balance);
                    }

                    break;

                case 3:
                    System.out.print("Enter the amount you wish to withdraw: ");
                    double withdraw = scanner.nextDouble();

                    if (withdraw <= 0) {
                        System.out.println("Invalid withdrawal amount!");
                        System.out.println("Withdrawal amount must be greater than 0.");

                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                        System.out.println("Your current balance is: ₹" + balance);

                    } else {
                        balance -= withdraw;
                        System.out.println("₹" + withdraw + " withdrawn successfully.");
                        System.out.println("Remaining Balance: ₹" + balance);
                    }

                    break;

                case 4:
                    System.out.println("Thank you for using Simple ATM!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
                    System.out.println("Please choose a number between 1 and 4.");
            }
        }
    }
}
