import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissor {

    public static String getComputerChoice(ArrayList<String> choices){
        Random random = new Random();
        int randomIndex = random.nextInt(choices.size());
        return choices.get(randomIndex);
    }

    public static String determineUser(String userChoice, String computerChoice){
        if(userChoice.equals(computerChoice)){
            return "tie";
        }else if(userChoice.equals("ROCK") && computerChoice.equals("PAPER")){
            return "computer";
        }else if(userChoice.equals("ROCK") && computerChoice.equals("SCISSOR")){
            return "user";
        }else if(userChoice.equals("PAPER") && computerChoice.equals("ROCK")){
            return "user";
        }else{
            return "computer";
        }
    }

    public static void printScore(int userScore, int computerScore, int tie){
        System.out.println("\n          ScoreBoard");
        System.out.println("--------------------------------");
        System.out.printf("User: %d|   Computer: %d|  Tie: %d \n\n", userScore, computerScore, tie);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> choices = new ArrayList<>();
        choices.add("ROCK");
        choices.add("PAPER");
        choices.add("SCISSOR");

        int userScore = 0;
        int computerScore = 0;
        int tie = 0;

        System.out.println("================================");
        System.out.println("       ROCK PAPER SCISSOR");
        System.out.println("================================\n");

        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();

        for(int i = 1; i < rounds + 1; i++){
            System.out.println("------ Round " + i + " ------");

            System.out.print("Enter your choice: ");
            String userChoice = scanner.next().toUpperCase();

            String computerChoice = getComputerChoice(choices).toUpperCase();
            System.out.println("Computer Choose: " + computerChoice);

            System.out.print("Result: ");

            if(determineUser(userChoice, computerChoice).equals("user")){
                userScore++;
                System.out.print("YOU WON THIS ROUND (+1 SCORE)\n");
            }else if(determineUser(userChoice, computerChoice).equals("computer")){
                computerScore++;
                System.out.println("COMPUTER WON THIS ROUND (+1 COMPUTER)\n");
            }else{
                tie++;
                System.out.println("TIE!!! (+1 TIE)\n");
            }

            printScore(userScore, computerScore, tie);
        }

        if(userScore > computerScore){
            System.out.println("YOU WON!!!");
        }else if(userScore < computerScore){
            System.out.println("COMPUTER WON!!!");
        }else{
            System.out.println("TIE");
        }
        scanner.close();
    }
}
