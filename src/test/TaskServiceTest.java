package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    // Test to add a task
    @Test
    void testAddTask() {
        Task task = new Task("1234567890", "Task Name", "Valid task description.");
        taskService.addTask(task);
        Assertions.assertEquals(task, taskService.getTask("1234567890"));
    }

    // Test to check duplicate taskId
    @Test
    void testAddDuplicateTaskId() {
        Task task1 = new Task("1234567890", "Task Name", "Valid task description.");
        Task task2 = new Task("1234567890", "New Task", "Another description.");
        taskService.addTask(task1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    // Test deleteTask method
    @Test
    void testDeleteTask() {
        Task task = new Task("50", "Task Name", "Valid task description.");
        taskService.addTask(task);
        taskService.deleteTask("50");

        // Trying to get a task that doesnt exist
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask("50");
        });
    }

    // Tests updateTaskName method
    @Test
    void testUpdateTaskName() {
        Task task = new Task("1234567890", "Old Name", "Valid task description.");
        taskService.addTask(task);
        taskService.updateTaskName("1234567890", "New Name");
        Assertions.assertEquals("New Name", taskService.getTask("1234567890").getName());
    }

    // Tests updateTaskDescription method
    @Test
    void testUpdateTaskDescription() {
        Task task = new Task("1234567890", "Task Name", "Old description.");
        taskService.addTask(task);
        taskService.updateTaskDescription("1234567890", "New description.");
        Assertions.assertEquals("New description.", taskService.getTask("1234567890").getDescription());
    }
}