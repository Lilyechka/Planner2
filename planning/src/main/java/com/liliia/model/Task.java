package com.liliia.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_task;

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

    @PrePersist
    protected void onCreate() {
        date_of_creation = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getIdTask() {
        return id_task;
    }

    public void setIdTask(Long idTask) {
        this.id_task = idTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDateOfCreation() {
        return date_of_creation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.date_of_creation = dateOfCreation;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description_task;
    }

    public void setDescription(String descriptionTask) {
        this.description_task = descriptionTask;
    }

}
