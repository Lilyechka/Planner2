package com.liliia.Repository;

import com.liliia.model.Task;
import com.liliia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer userId);
    Optional<Task> findByIdAndUser(Integer taskId, User user);
}
