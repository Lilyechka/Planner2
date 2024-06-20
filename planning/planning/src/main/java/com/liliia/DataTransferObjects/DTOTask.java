package com.liliia.DataTransferObjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class DTOTask {
    private long id;

    private String author;

    @NotBlank(message = "Topic is mandatory")
    private String topic;

    private LocalDateTime date_of_create;

    @NotNull(message = "Deadline date is mandatory")
    private LocalDateTime deadline;

    @NotBlank(message = "Description is mandatory")
    private String description_task;

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDateTime getDate_of_creation() {
        return date_of_create;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getDescription_task() {
        return description_task;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDate_of_creation(LocalDateTime date_of_create) {
        this.date_of_create = date_of_create;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline= deadline;
    }

    public void setDescription_task(String description_task) {
        this.description_task = description_task;
    }

}
