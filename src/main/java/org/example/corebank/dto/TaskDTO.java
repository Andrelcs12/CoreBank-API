package org.example.corebank.dto;

import org.example.corebank.entity.Task;

import java.time.LocalDateTime;

public class TaskDTO {

    public record CreateRequest (
            String title,
            String description,
            Task.Priority priority
    ) {}


    public record UpdateRequest(
            String title,
            String description,
            Task.Priority priority,
            Boolean completed
    ) {}


    public record Response(
            Long id,
            String title,
            String description,
            Task.Priority priority,
            Boolean completed,
            LocalDateTime createdAt,
            LocalDateTime updateAt
    ) {}

    public record DeleteRequest(

    ) {}
}
