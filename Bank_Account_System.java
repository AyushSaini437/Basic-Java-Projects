import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private static int nextAccNumber = 1;

    private String accNumber;
    private String name;
    private double balance;

    public BankAccount(String name, double initialDeposit) {
        this.accNumber = String.format("ACC-%03d", nextAccNumber++);
        this.name = name;
        this.balance = initialDeposit;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Account Number: %s | Holder: %s | Balance: $%.2f", accNumber, name, balance);
    }
}

class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public BankAccount openAccount(String name, double initialDeposit) {
        BankAccount newAccount = new BankAccount(name, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(String accNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccNumber().equalsIgnoreCase(accNumber)) {
                return acc;
            }
        }
        return null; // Account not found
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found in the bank system.");
            return;
        }
        System.out.println("\n----------------- ALL ACCOUNTS -----------------");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("------------------------------------------------");
    }
}

public class Bank_Account_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;

        System.out.println("========================================");
        System.out.println("       WELCOME TO BANK SYSTEM      ");
        System.out.println("========================================");

        while (running) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Account Details");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit amount: $");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer

                    if (initialDeposit < 0) {
                        System.out.println("[FAILED] Initial deposit cannot be negative.");
                    } else {
                        BankAccount acc = bank.openAccount(name, initialDeposit);
                        System.out.println("\n[SUCCESS] Account created successfully!");
                        System.out.println(acc);
                    }
                }
                case 2 -> {
                    System.out.print("Enter account number (e.g., ACC-001): ");
                    String accNum = scanner.nextLine();
                    BankAccount acc = bank.findAccount(accNum);

                    if (acc != null) {
                        System.out.print("Enter amount to deposit: $");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        if (acc.deposit(amount)) {
                            System.out.printf("[SUCCESS] Deposited $%.2f. New Balance: $%.2f%n", amount, acc.getBalance());
                        } else {
                            System.out.println("[FAILED] Deposit amount must be greater than $0.");
                        }
                    } else {
                        System.out.println("[FAILED] Account not found!");
                    }
                }
                case 3 -> {
                    System.out.print("Enter account number (e.g., ACC-001): ");
                    String accNum = scanner.nextLine();
                    BankAccount acc = bank.findAccount(accNum);

                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: $");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        if (acc.withdraw(amount)) {
                            System.out.printf("[SUCCESS] Withdrew $%.2f. New Balance: $%.2f%n", amount, acc.getBalance());
                        } else {
                            System.out.println("[FAILED] Invalid amount or insufficient funds.");
                        }
                    } else {
                        System.out.println("[FAILED] Account not found!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter account number (e.g., ACC-001): ");
                    String accNum = scanner.nextLine();
                    BankAccount acc = bank.findAccount(accNum);

                    if (acc != null) {
                        System.out.println("\n--- ACCOUNT DETAILS ---");
                        System.out.println(acc);
                    } else {
                        System.out.println("[FAILED] Account not found!");
                    }
                }
                case 5 -> bank.displayAllAccounts();
                case 6 -> {
                    running = false;
                    System.out.println("\nThank you for banking with us. Goodbye!");
                }
                default -> System.out.println("Invalid choice! Please choose between 1 and 6.");
            }
        }

        scanner.close();
    }
}