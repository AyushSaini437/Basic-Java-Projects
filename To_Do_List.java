import java.util.ArrayList;
import java.util.Scanner;

class Task{
    private String description;
    private boolean isCompleted;

    public Task(String description){
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription(){
        return description;
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public void markCompleted(){
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task [description=" + description + ", isCompleted=" + isCompleted + "]";
    }

    
}

public class To_Do_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        int choice;

        while (true) {
            System.out.println("=====================");
            System.out.println("     TO-DO LIST");
            System.out.println("=====================");

            System.out.println("\n 1. View Task");
            System.out.println("\n 2. Add Task");
            System.out.println("\n 3. Mark as Completed");
            System.out.println("\n 4. Remove Task");
            System.out.println("\n 5. Exit");

            System.out.print("\n Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1 -> {
                    if(tasks.isEmpty()){
                        System.out.println("Your To-Do List is Empty.");
                    }else{
                        System.out.println("Your tasks:");
                        for(int i = 0; i < tasks.size(); i++){
                            System.out.println((i+1) + ". " + tasks.get(i));
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter your Task description: ");
                    String desc = scanner.nextLine();
                    tasks.add(new Task(desc));
                    System.out.println("Task added Successfully!!!");
                }
                case 3 -> {
                    System.out.print("Enter your task number: ");
                    int index = scanner.nextInt() - 1;

                    if(index >= 0 && index < tasks.size()){
                        tasks.get(index).markCompleted();
                        System.out.println("Task marked successfully.");
                    }else{
                        System.out.println("Invalid Task number.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter your task number: ");
                    int index = scanner.nextInt() - 1;
                    
                    if(index >= 0 && index < tasks.size()){
                        tasks.remove(index);
                        System.out.println("Task removed successfully.");
                    }else{
                        System.out.println("Invalid Task number.");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting application. GoodBye!!!");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid Choice.");
                }
            }

        }
    }
}
