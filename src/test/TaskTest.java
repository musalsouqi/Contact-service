package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

    // Test for taskId longer than 10 characters
    @Test
    void testTaskIdLongerThanTen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678910", "Task Name", "Task description.");
        });
    }

    // Test for taskId not being null
    @Test
    void testTaskIdNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task description.");
        });
    }

    // Test for name longer than 20 characters
    @Test
    void testNameLongerThanTwenty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "This name is way too long", "Task description.");
        });
    }

    // Test for name not being null
    @Test
    void testNameNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", null, "Task description.");
        });
    }

    // Test for description longer than 50 characters
    @Test
    void testDescriptionLongerThanFifty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", "This description is way too long and exceeds the fifty-character limit.");
        });
    }

    // Test for description not being null
    @Test
    void testDescriptionNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Task Name", null);
        });
    }

    // Test for valid task creation
    @Test
    void testValidTaskCreation() {
        Task task = new Task("1234567890", "Task Name", "Valid task description.");
        Assertions.assertEquals("1234567890", task.getTaskId());
        Assertions.assertEquals("Task Name", task.getName());
        Assertions.assertEquals("Valid task description.", task.getDescription());
    }
}