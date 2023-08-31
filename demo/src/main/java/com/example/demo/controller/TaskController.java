package com.example.demo.controller;

import com.example.demo.model.TaskEntity;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/alltasks")
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        List<TaskEntity> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addtask")
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity taskEntity) {
        TaskEntity savedTask = taskService.saveTask(taskEntity);
        return ResponseEntity.ok(savedTask);
    }

    @PutMapping("/edittask/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable long id, @RequestBody TaskEntity taskEntity) {
        if (!taskService.getTaskById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        taskEntity.setId(id);
        TaskEntity updatedTask = taskService.saveTask(taskEntity);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/deletetask/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        if (!taskService.getTaskById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
