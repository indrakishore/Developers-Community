import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String title, String description, LocalDate dueDate) {
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
        this.completed = false;
    }

    // Getters and setters (unchanged)
    public String getTitle() { return title; }
    public void setTitle(String title) { 
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title; 
    }
    public String getDescription() { return description; }
    public void setDescription(String description) { 
        if (description == null || description.trim().isEmpty()) throw new IllegalArgumentException("Description cannot be empty");
        this.description = description; 
    }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { 
        if (dueDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("Due date cannot be in the past");
        this.dueDate = dueDate; 
    }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        return "Task: " + title + ", Description: " + description + ", Due Date: " + dueDate + ", Completed: " + completed;
    }
}
