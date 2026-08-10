import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static int getRandomNumber(int lowerLimit, int upperLimit){
        Random random = new Random();
        return random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your lower limit: ");
        int lowerLimit = scanner.nextInt();

        System.out.print("Enter your upper limit: ");
        int upperLimit = scanner.nextInt();

        if (lowerLimit >= upperLimit) {
            System.out.println("Invalid limits!");
            System.out.println("The lower limit must be less than the upper limit.");
            scanner.close();
            return;
        }

        int randomNumber = getRandomNumber(lowerLimit, upperLimit);

        int lives = 3;
        boolean guessedCorrectly = false;

        System.out.println("==========================");
        System.out.println("Number Guessing Game");
        System.out.println("==========================");
        System.out.println("I have chosen a number between " + lowerLimit + " and " + upperLimit);

        while (lives > 0) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess > randomNumber) {
                System.out.println("Your guess is too high!");
                lives--;
            } else if (guess < randomNumber) {
                System.out.println("Your guess is too low!");
                lives--;
            } else {
                System.out.println("You've guessed the number!!!!");
                guessedCorrectly = true;
                break;
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You won!");
            System.out.println("Your points gained are: " + lives * 10);
        } else {
            System.out.println("You ran out of lives!");
            System.out.println("The number was: " + randomNumber);
            System.out.println("Your points gained are: 0");
        }

        scanner.close();
    }
}
