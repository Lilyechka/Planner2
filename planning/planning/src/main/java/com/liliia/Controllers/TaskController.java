package com.liliia.Controllers;

import com.liliia.DataTransferObjects.DTOTask;
import com.liliia.Repository.TaskRepository;
import com.liliia.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService, TaskRepository taskRepository){
        this.taskService = taskService;
    }

    @GetMapping
    public List<DTOTask> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping(value = "/{taskId}")
    public DTOTask getTaskById(@PathVariable("taskId") Integer id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    public DTOTask createTask(@RequestBody @Valid DTOTask taskDTO){
        return taskService.createNewTask(taskDTO);
    }

    @PutMapping(value = "/{taskId}")
    public DTOTask updateTaskInfo(@PathVariable("taskId") Integer id, @RequestBody @Valid DTOTask taskDTO) {
        return taskService.editTask(id, taskDTO);
    }

    @DeleteMapping(value = "/{taskId}")
    public void deleteTask(@PathVariable("taskId") Integer id) {
        taskService.deleteTask(id);
    }
}
