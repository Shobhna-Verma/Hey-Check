import java.util.Date;

public class Task {
    private String title;        // Task title
    private String description;  // Task description
    private Date dueDate;        // Task due date
    private String category;     // Task category
    private int priority;        // Task priority
    private boolean isCompleted; // Field to track completion status

    // Constructor to initialize a new task with provided values
    public Task(String title, String description, Date dueDate, String category, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
        this.isCompleted = false; // Default to not completed
    }

    // Getter method to retrieve the task's title
    public String getTitle() {
        return title;
    }

    // Setter method to update the task's title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for completion status
    public boolean isCompleted() {
        return isCompleted;
    }

    // Setter for completion status
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    // Returns a string representation of the task, showing completion status
    @Override
    public String toString() {
        String completedStatus = isCompleted ? "[Completed]" : "[Not Completed]";
        return completedStatus + " Title: " + title + ", Description: " + description + ", Due Date: " + dueDate + ", Category: " + category + ", Priority: " + priority;
    }
}
