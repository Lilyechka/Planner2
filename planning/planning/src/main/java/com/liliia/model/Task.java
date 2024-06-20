package com.liliia.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false)
    private LocalDateTime date_of_creation;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column(nullable = false, length = 10000)
    private String description_task;

    public Task() {

    }

    @PrePersist
    protected void onCreate() {
        date_of_creation = LocalDateTime.now();
    }

    public long getIdTask() {
        return id_task;
    }

    public void setIdTask(Long idTask) {
        this.id_task = idTask;
    }

    public Task(String topic, LocalDateTime deadline_date, String description, User user) {
        this.topic = topic;
        this.date_of_creation = LocalDateTime.now();
        this.deadline = deadline_date;
        this.description_task = description;
        this.user = user;
    }


    public long getId() {
        return id_task;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDateTime getDate_of_creation() {
        return date_of_creation;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getDescription_task() {
        return description_task;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id_task = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDate_of_creation(LocalDateTime creation_date) {
        this.date_of_creation = creation_date;
    }

    public void setDeadline(LocalDateTime deadline_date) {
        this.deadline = deadline_date;
    }

    public void setDescription_task(String description) {
        this.description_task = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id_task +
                ", topic='" + topic + '\'' +
                ", creation_date=" + date_of_creation +
                ", deadline_date=" + deadline +
                ", description='" + description_task + '\'' +
                '}';
    }
}