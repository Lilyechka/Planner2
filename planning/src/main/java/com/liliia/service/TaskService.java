package com.liliia.service;

import com.liliia.model.Task;
import com.liliia.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByUserId(Long id_user) {
        return taskRepository.findByUserId(Math.toIntExact(id_user));
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Long taskId, Task task) {
        Task existingTask = taskRepository.findById(id_task).orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setTopic(task.getTopic());
        existingTask.setDescription(task.getDescription());
        taskRepository.save(existingTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(id_task);
    }
}
