import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Question{
    private String question;
    private String[] options;
    private char answer;

    public static ArrayList<Question> questionBank = new ArrayList<>();

    public Question(String question, String[] options, char answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    static{
        questionBank.add(new Question(
            "Which of these data structures in Java resizes dynamically?", 
            new String[]{"A. Array", "B. Array List", "C. Enum", "D. Premitive Array"}, 
            'B'
        ));
        questionBank.add(new Question(
            "What happens if you try to access list.get(5) when the ArrayList size is 3?", 
            new String[]{"A. Returns null", "B. Expands the array size to 5", "C. Throws IndexOutOfBoundsException", "D. Returns the last element"}, 
            'C'
        ));
        questionBank.add(new Question(
            "Which method is used to remove all elements from an ArrayList in Java?", 
            new String[]{"A. removeAll()", "B. clear()", "C. delete()", "D. reset()"},
            'B'
        ));
        questionBank.add(new Question(
            "Which utility class method allows you to easily shuffle elements in a Java List randomly?", 
            new String[]{"A. Math.randomList()", "B. Random.shuffle()", "C. Collections.shuffle()", "D. Arrays.randomize()"}, 
            'C'
        ));
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public char getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question [question=" + question + ", options=" + Arrays.toString(options);
    }
    
}

public class Quiz_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collections.shuffle(Question.questionBank);

        int score = 0;
        int numberOfQuestions = 0;
        System.out.println("=========================");
        System.out.println("        QUIZ GAME");
        System.out.println("=========================\n");

        for(int i = 0; i < 2; i++){
            numberOfQuestions++;
            Question currentQuestion = Question.questionBank.get(i);
            System.out.println("Q"+ (i+1) +". " + currentQuestion.getQuestion());

            String[] options = currentQuestion.getOptions();

            for(int j = 0; j < options.length; j++){
                System.out.println(options[j]);
            }
            System.out.print("Enter your answer (A, B, C, or D): ");
            char answer = scanner.next().toUpperCase().charAt(0);

            if(currentQuestion.getAnswer() == answer){
                score++;
                System.out.println("Correct!");
            }else{
                System.out.println("Incorrect! The correct answer was " + currentQuestion.getAnswer() + " .");
            }

            System.out.println("\n-------------------------\n");
        }

        System.out.println("=========================");
        System.out.println("        QUIZ OVER");
        System.out.println("=========================\n");

        System.out.println("Your Score: " + score + "/" + numberOfQuestions+ " (" + ((float)score/numberOfQuestions)*100 + ")%");
    }
}
