import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JFrame frame;
    private JTextField taskTitleField;
    private JTextArea taskDescriptionArea;
    private JComboBox<String> categoryComboBox;
    private JComboBox<String> priorityComboBox;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private TaskManager taskManager;

    public UI() {
        taskManager = new TaskManager();
        listModel = new DefaultListModel<>();

        // Set up the main frame
        frame = new JFrame("To-Do List Application");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Task input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Task Title:"));
        taskTitleField = new JTextField();
        inputPanel.add(taskTitleField);

        inputPanel.add(new JLabel("Task Description:"));
        taskDescriptionArea = new JTextArea(4, 20);
        inputPanel.add(new JScrollPane(taskDescriptionArea));

        inputPanel.add(new JLabel("Category:"));
        categoryComboBox = new JComboBox<>(new String[] { "Work", "Personal", "Urgent" });
        inputPanel.add(categoryComboBox);

        inputPanel.add(new JLabel("Priority:"));
        priorityComboBox = new JComboBox<>(new String[] { "Low", "Medium", "High" });
        inputPanel.add(priorityComboBox);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Task list display
        taskList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(taskList);
        frame.add(listScrollPane, BorderLayout.CENTER);

        // Add, Remove, and Mark as Completed buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");
        JButton completeButton = new JButton("Mark as Completed");

        // Add Task Button ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = taskTitleField.getText();
                String description = taskDescriptionArea.getText();
                String category = (String) categoryComboBox.getSelectedItem();
                int priority = priorityComboBox.getSelectedIndex() + 1; // 1: Low, 2: Medium, 3: High

                if (!title.isEmpty() && !description.isEmpty()) {
                    Task newTask = new Task(title, description, new java.util.Date(), category, priority);
                    taskManager.addTask(newTask);
                    listModel.addElement(newTask.getTitle());
                    taskTitleField.setText("");
                    taskDescriptionArea.setText("");
                }
            }
        });

        // Remove Task Button ActionListener
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTaskTitle = taskList.getSelectedValue();
                if (selectedTaskTitle != null) {
                    // Remove task from TaskManager and list
                    for (Task task : taskManager.getTasks()) {
                        if (task.getTitle().equals(selectedTaskTitle)) {
                            taskManager.removeTask(task);
                            listModel.removeElement(selectedTaskTitle);
                            break;
                        }
                    }
                }
            }
        });

        // Mark as Completed Button ActionListener
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTaskTitle = taskList.getSelectedValue();
                if (selectedTaskTitle != null) {
                    // Mark selected task as completed
                    for (Task task : taskManager.getTasks()) {
                        if (task.getTitle().equals(selectedTaskTitle)) {
                            taskManager.markTaskAsCompleted(task);
                            // Update list model to show that the task is completed
                            listModel.setElementAt(task.toString(), taskManager.getTasks().indexOf(task));
                            break;
                        }
                    }
                }
            }
        });

        // Add buttons to button panel
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(completeButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UI(); // Run the application
    }
}
