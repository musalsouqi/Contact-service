package Task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> taskMap = new HashMap<>();

    // Adds a new task with a unique ID
    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("ID already exists");
        }
        taskMap.put(task.getTaskId(), task);
    }

    // Deletes a task
    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("No task with that id.");
        }
        taskMap.remove(taskId);
    }

    // Retrieves a task by ID
    public Task getTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("No task with that id.");
        }
        return taskMap.get(taskId);
    }

    // Updates the name of a task
    public void updateTaskName(String taskId, String name) {
        Task task = getTask(taskId);
        task.setName(name);
    }

    // Updates the description of a task
    public void updateTaskDescription(String taskId, String description) {
        Task task = getTask(taskId);
        task.setDescription(description);
    }
}