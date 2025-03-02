package Task;

public class Task {
    private final String taskId; // Unique and cannot be changed
    private String name;
    private String description;

    // Constructor
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("taskId not entered or is over 10 characters long");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("name not entered or is over 20 characters long");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("description not entered or is over 50 characters long");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters for updatable fields
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("name not entered or is over 20 characters long");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("description not entered or is over 50 characters long");
        }
        this.description = description;
    }
}