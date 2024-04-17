package com.example.jiuteiro.demo.controller;

import com.example.jiuteiro.demo.dto.TaskRequest;
import com.example.jiuteiro.demo.dto.UserRequest;
import com.example.jiuteiro.demo.exception.TaskNotFoundException;
import com.example.jiuteiro.demo.exception.UserNotFoundException;
import com.example.jiuteiro.demo.model.Task;
import com.example.jiuteiro.demo.model.User;
import com.example.jiuteiro.demo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{task_id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long task_id) {
        try {
            Task task = taskService.getTaskById(task_id);
            return ResponseEntity.ok(task);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllUsers() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }
    @PostMapping("/addTask")
    public ResponseEntity<Task> saveTask() {
        return new ResponseEntity<>(taskService.saveTask(new TaskRequest("New Task", false)), HttpStatus.CREATED);
    }
    @DeleteMapping("/tasks/{task_id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long task_id) {
        try {
            return ResponseEntity.ok(taskService.deleteTask(task_id));
        } catch (TaskNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/tasks/{task_id}")
    public ResponseEntity<?> updateStatusById(@PathVariable Long task_id, @RequestBody Task body) {
        //call the service
        //get the dat back from server
        Task updatedTask = taskService.updateStatus(task_id, body);
        //send it back to frontend
        return ResponseEntity.ok(updatedTask);
    }
}

