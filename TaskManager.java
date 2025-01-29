import java.util.ArrayList;
import java.util.List;

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

    // Get all tasks
    public List<Task> getTasks() {
        return tasks;
    }
}
