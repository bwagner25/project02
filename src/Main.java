import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            ArrayList<Task> tasks = new ArrayList<>();
            System.out.println("\nWhat would you like to do?\n(1) Add a task.\n(2) Remove a task.\n(3) Update a task.\n(4) List tasks.\n(0) Exit.\n");
            String userInput = input.nextLine();
            while (!(userInput.equals("0"))) {
                if (userInput.equals("1")) {
                    addTask(tasks);
                }
                if (userInput.equals("2")) {
                    removeTask(tasks);
                }
                if (userInput.equals("3")) {
                    updateTask(tasks);
                }
                if (userInput.equals("4")) {
                    listTasks(tasks);
                }
                System.out.println("\nWhat would you like to do?\n(1) Add a task.\n(2) Remove a task.\n(3) Update a task.\n(4) List tasks.\n(0) Exit.\n");
                userInput = input.nextLine();
            }
        }catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }
    static void addTask(ArrayList<Task> a){
        System.out.println("What is the title of the task you want to add?");

        String newTaskTitle = input.nextLine();
        System.out.println("Describe the task you want to add.");
        String newTaskDesc = input.nextLine();
        System.out.println("From 0-5, what is the priority of the task?");
        int newTaskPriority = parseInt(input.nextLine());
        boolean validInput = false;
        while(!validInput){
            switch(newTaskPriority){
                case 0, 1, 2, 3, 4, 5 -> validInput = true;
                default -> {
                    System.out.println("That isn't a valid priority. Try again.");
                    newTaskPriority = parseInt(input.nextLine());
                }
            }

        }
        Task NewTask = new Task(newTaskTitle,newTaskDesc,newTaskPriority);
        a.add(NewTask);
    }
    static void removeTask(ArrayList<Task> a){
        System.out.println("Which number task would you like to remove?");
        String taskNumber = input.nextLine();
        int taskIndex = parseInt(taskNumber) - 1;
        a.remove(taskIndex);
    }
    static void updateTask(ArrayList<Task> a){
        System.out.println("Which number task would you like to update?");
        String taskNumber = input.nextLine();
        int taskIndex = parseInt(taskNumber) - 1;
        System.out.println("What is the title of the updated task.");
        String updatedTitle = input.nextLine();
        System.out.println("What is the description of the updated task?");
        String updatedDesc = input.nextLine();
        System.out.println("What is the priority of the updated task?");
        int updatedPriority = parseInt(input.nextLine());
        Task updatedTask = new Task(updatedTitle, updatedDesc, updatedPriority);
        a.set(taskIndex, updatedTask);
    }

    static void listTasks(ArrayList<Task> a){
        System.out.println("What priority would you like to list? (0-5 or all)");
        String priority = input.nextLine();
        boolean validInput = false;
        while(!validInput){
            switch (priority) {
                case "0" -> {
                    validInput = true;
                    for (Task task : a) {
                        if (task.getPriority() == 0) {
                            System.out.println(task);
                        }
                    }
                }
                case "1" -> {
                    validInput = true;
                    for (Task task : a) {
                        if (task.getPriority() == 1) {
                            System.out.println(task);
                        }
                    }
                }
                case "2" -> {
                    validInput = true;
                    for (Task task : a) {
                        if (task.getPriority() == 2) {
                            System.out.println(task);
                        }
                    }
                }
                case "3" -> {
                    validInput = true;
                    for (Task task : a) {
                        if (task.getPriority() == 3) {
                            System.out.println(task);
                        }
                    }
                }
                case "4" -> {
                    validInput = true;
                    for (Task task : a) {
                        if (task.getPriority() == 4) {
                            System.out.println(task);
                        }
                    }
                }
                case "5" -> {
                    validInput = true;
                    for (Task task : a) {
                        if (task.getPriority() == 5) {
                            System.out.println(task);
                        }
                    }
                }
                case "all" -> {
                    validInput = true;
                    System.out.println(a);
                }
                default -> {
                    System.out.println("That's not one of the options. Try again.");
                    priority = input.nextLine();
                }
            }
        }
    }
}