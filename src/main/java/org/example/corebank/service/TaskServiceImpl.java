package org.example.corebank.service;


import lombok.RequiredArgsConstructor;
import org.example.corebank.entity.Task;
import org.example.corebank.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        validateTask(task);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        validateTask(task);
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        applyUpdates(existingTask, task);
        validateTask(existingTask);

        return taskRepository.save(existingTask);


    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    private void validateTask(Task task) {
        if (task.getTitle() == null || task.getTitle().length() == 0) {
            throw new RuntimeException("Title is empty");
        }
        if (task.getDescription() == null || task.getDescription().length() == 0) {
            throw new RuntimeException("Description is empty");
        }

    }

    private void applyUpdates(Task existing, Task incoming) {
        existing.setTitle(incoming.getTitle());
        existing.setDescription(incoming.getDescription());
        existing.setPriority(incoming.getPriority());
        existing.setCompleted(incoming.getCompleted());
    }

}



