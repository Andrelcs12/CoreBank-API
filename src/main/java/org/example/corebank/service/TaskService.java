package org.example.corebank.service;

import org.example.corebank.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    void deleteTask(Long id);

}
