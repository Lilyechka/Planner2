package com.liliia.service;

import com.liliia.DataTransferObjects.DTOTask;
import com.liliia.model.Task;
import com.liliia.model.User;
import com.liliia.Repository.TaskRepository;
import com.liliia.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    private final UserRepository userRepository;


    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<DTOTask> getTasks(){
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<Task> tasks;
        if(Objects.equals(currentUser.getRole(), "ADMIN")){
            tasks = taskRepository.findAll();
            return tasks.stream().map(this::convertToDTO).collect(Collectors.toList());
        }
        else{
            tasks = taskRepository.findByUserId(currentUser.getId());
        }
        return tasks.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    public DTOTask getTaskById(Integer id) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Task task;
        if(Objects.equals(currentUser.getRole(), "ADMIN")){
            task = taskRepository.findById(id).orElseThrow(() -> new IllegalStateException("Task with this id doesn't exist"));
            return convertToDTO(task);
        }
        else {
            task = taskRepository.findByIdAndUser(id, currentUser)
                    .orElseThrow(() -> new IllegalStateException("Task with this id doesn't exist or doesn't belong to the current user"));
        }
        return convertToDTO(task);
    }

    public DTOTask addNewTask(DTOTask taskDTO) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Task task = new Task();
        if(Objects.equals(currentUser.getRole(), "ADMIN")){

            User assignedUser = userRepository.findByUsername(taskDTO.getAuthor())
                    .orElseThrow(() -> new UsernameNotFoundException("User to assign task not found"));
            task.setUser(assignedUser);

        }
        else{
            task.setUser(currentUser);
        }
        task.setTopic(taskDTO.getTopic());
        task.setDate_of_creation(LocalDateTime.now());
        task.setDeadline(taskDTO.getDeadline());
        task.setDescription_task(taskDTO.getDescription_task());
        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
    }

    public DTOTask updateTaskInfo(Integer id, DTOTask taskDTO) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Task oldTask;
        Task newTask = new Task();

        if (Objects.equals(currentUser.getRole(), "ADMIN")) {

            oldTask = taskRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("Task with this id doesn't exist"));

            newTask.setDate_of_creation(oldTask.getDate_of_creation());
            taskRepository.delete(oldTask);

            User assignedUser = userRepository.findByUsername(taskDTO.getAuthor())
                    .orElseThrow(() -> new UsernameNotFoundException("User to assign task not found"));

            newTask.setUser(assignedUser);
        }
        else {

            oldTask = taskRepository.findByIdAndUser(id, currentUser)
                    .orElseThrow(() -> new IllegalStateException("Task with this id doesn't exist or doesn't belong to the current user"));

            newTask.setDate_of_creation(oldTask.getDate_of_creation());
            taskRepository.delete(oldTask);

            newTask.setUser(currentUser);
        }

        newTask.setTopic(taskDTO.getTopic());
        newTask.setDeadline(taskDTO.getDeadline());
        newTask.setDescription_task(taskDTO.getDescription_task());
        Task updatedTask = taskRepository.save(newTask);
        return convertToDTO(updatedTask);
    }


    public void deleteTask(Integer id) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Task task;
        if(Objects.equals(currentUser.getRole(), "ADMIN")){
            task = taskRepository.findById(id).orElseThrow(() -> new IllegalStateException("Task with this id doesn't exist"));
        }
        else{
            task = taskRepository.findByIdAndUser(id, currentUser)
                    .orElseThrow(() -> new IllegalStateException("Task with this id doesn't exist or doesn't belong to the current user"));
        }

        taskRepository.delete(task);

    }

    private DTOTask convertToDTO(Task task) {
        DTOTask taskDTO = new DTOTask();
        taskDTO.setId(task.getId());
        taskDTO.setAuthor(task.getUser().getName());
        taskDTO.setTopic(task.getTopic());
        taskDTO.setDate_of_creation(task.getDate_of_creation());
        taskDTO.setDeadline(task.getDeadline());
        taskDTO.setDescription_task(task.getDescription_task());
        return taskDTO;
    }
}