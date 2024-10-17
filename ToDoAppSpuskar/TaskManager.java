import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, String description, LocalDate dueDate) {
        tasks.add(new Task(title, description, dueDate));
    }

    public void editTask(int index, String title, String description, LocalDate dueDate) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setTitle(title);
            task.setDescription(description);
            task.setDueDate(dueDate);
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("To-Do #" + (i + 1) + ": " + tasks.get(i));
            }
        }
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}
