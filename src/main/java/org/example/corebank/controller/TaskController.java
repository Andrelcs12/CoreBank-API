package org.example.corebank.controller;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.corebank.dto.TaskDTO;
import org.example.corebank.entity.Task;
import org.example.corebank.mapper.TaskMapper;
import org.example.corebank.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO.Response> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);

        return ResponseEntity.ok(TaskMapper.toResponse(createdTask));
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        return taskService.findById(id)
                .map(ResponseEntity::ok)
                .orElse((ResponseEntity.notFound().build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(
            @PathVariable Long id,
            @RequestBody Task task
    ) {
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
