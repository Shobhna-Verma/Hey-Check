public class Task {
    private String title;        // Task title
    private String description;  // Task description
    private java.util.Date dueDate; // Task due date
    private String category;     // Task category
    private int priority;        // Task priority

    // Constructor to initialize a new task with provided values
    public Task(String title, String description, java.util.Date dueDate, String category, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
    }

    // Getter method to retrieve the task's title
    public String getTitle() {
        return title;
    }

    // Setter method to update the task's title
    public void setTitle(String title) {
        this.title = title;
    }

    // Returns a string representation of the task
    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description + ", Due Date: " + dueDate + ", Category: " + category + ", Priority: " + priority;
    }
}
