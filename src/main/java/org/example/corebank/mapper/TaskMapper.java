package org.example.corebank.mapper;

import org.example.corebank.dto.TaskDTO;
import org.example.corebank.entity.Task;

public class TaskMapper {

    public static Task toEntity(TaskDTO.CreateRequest dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setPriority(dto.priority());
        return task;
    }

    public static TaskDTO.Response toResponse(Task task) {
        return new TaskDTO.Response(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getCompleted(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
