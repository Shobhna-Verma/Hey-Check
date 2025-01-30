import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // Add a task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Remove a task
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    // Update a task (For simplicity, we update only the title here)
    public void updateTask(Task task, String newTitle) {
        task.setTitle(newTitle);
    }

    // Mark a task as completed
    public void markTaskAsCompleted(Task task) {
        task.setCompleted(true);
    }

    // Mark a task as not completed
    public void markTaskAsNotCompleted(Task task) {
        task.setCompleted(false);
    }

    // Get all tasks
    public List<Task> getTasks() {
        return tasks;
    }

    // Get all completed tasks
    public List<Task> getCompletedTasks() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }

    // Get all not completed tasks
    public List<Task> getNotCompletedTasks() {
        return tasks.stream().filter(task -> !task.isCompleted()).collect(Collectors.toList());
    }

    // Toggle the completion status of a task
    public void toggleTaskCompletion(Task task) {
        task.setCompleted(!task.isCompleted());
    }
}
