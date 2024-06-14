package com.liliia.Controllers;

import com.liliia.model.Task;
import com.liliia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Map<String, String> taskDetails) {
        Task task = new Task();
        task.setTopic(taskDetails.get("topic"));
        task.setDeadline(LocalDateTime.parse(taskDetails.get("deadline")));
        task.setDescription(taskDetails.get("description"));
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Map<String, String> taskDetails) {
        Task task = taskService.getTaskById(taskId);
        task.setTopic(taskDetails.get("topic"));
        task.setDeadline(LocalDateTime.parse(taskDetails.get("deadline")));
        task.setDescription(taskDetails.get("description"));
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}