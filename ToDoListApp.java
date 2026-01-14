import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean completed;

    Task(String name) {
        this.name = name;
        this.completed = false;
    }
}

public class ToDoListApp {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
static void showMenu() {
    System.out.println("\n--- TO DO LIST MENU ---");
    System.out.println("1. Add Task");
    System.out.println("2. View Tasks");
    System.out.println("3. Mark Task as Completed");
    System.out.println("4. Delete Task");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
}


    public static void main(String[] args) {

        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = sc.nextLine();
                    tasks.add(new Task(taskName));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            Task t = tasks.get(i);
                            String status = t.completed ? "✔ Completed" : "❌ Pending";
                            System.out.println((i + 1) + ". " + t.name + " - " + status);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark completed: ");
                    int completeIndex = sc.nextInt() - 1;

                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        tasks.get(completeIndex).completed = true;
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = sc.nextInt() - 1;

                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("Task deleted successfully.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting To-Do List Application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
