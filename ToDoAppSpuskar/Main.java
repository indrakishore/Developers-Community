import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To-Do Application");
            System.out.println("1. Add To-Do");
            System.out.println("2. Edit To-Do");
            System.out.println("3. View All To-Dos");
            System.out.println("4. Delete To-Do");
            System.out.println("5. Mark To-Do as Completed");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 0 and 5.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                case 1:
                    addTodo(taskManager, scanner);
                    break;
                case 2:
                    editTodo(taskManager, scanner);
                    break;
                case 3:
                    taskManager.viewTasks();
                    break;
                case 4:
                    deleteTodo(taskManager, scanner);
                    break;
                case 5:
                    markTodoAsCompleted(taskManager, scanner);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
    }

    private static void addTodo(TaskManager taskManager, Scanner scanner) {
        System.out.print("Enter To-Do Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter To-Do Description: ");
        String description = scanner.nextLine();
        LocalDate dueDate = null;

        while (dueDate == null) {
            System.out.print("Enter Due Date (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine();

            try {
                dueDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        taskManager.addTask(title, description, dueDate);
        System.out.println("To-Do added successfully!");
    }

    private static void editTodo(TaskManager taskManager, Scanner scanner) {
        System.out.print("Enter To-Do number to edit: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskNumber > 0 && taskNumber <= taskManager.getTasks().size()) {
            System.out.print("Enter new Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new Description: ");
            String description = scanner.nextLine();
            LocalDate dueDate = null;

            while (dueDate == null) {
                System.out.print("Enter new Due Date (YYYY-MM-DD): ");
                String dateInput = scanner.nextLine();
                try {
                    dueDate = LocalDate.parse(dateInput);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please try again.");
                }
            }

            taskManager.editTask(taskNumber - 1, title, description, dueDate);
            System.out.println("To-Do edited successfully!");
        } else {
            System.out.println("Invalid To-Do number.");
        }
    }

    private static void deleteTodo(TaskManager taskManager, Scanner scanner) {
        System.out.print("Enter To-Do number to delete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= taskManager.getTasks().size()) {
            taskManager.deleteTask(taskNumber - 1);
            System.out.println("To-Do deleted successfully!");
        } else {
            System.out.println("Invalid To-Do number.");
        }
    }

    private static void markTodoAsCompleted(TaskManager taskManager, Scanner scanner) {
        System.out.print("Enter To-Do number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= taskManager.getTasks().size()) {
            taskManager.markTaskAsCompleted(taskNumber - 1);
            System.out.println("To-Do marked as completed successfully!");
        } else {
            System.out.println("Invalid To-Do number.");
        }
    }
}
