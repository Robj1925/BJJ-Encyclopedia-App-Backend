package com.example.jiuteiro.demo.service;

import com.example.jiuteiro.demo.dto.TaskRequest;
import com.example.jiuteiro.demo.exception.TaskNotFoundException;
import com.example.jiuteiro.demo.exception.UserNotFoundException;
import com.example.jiuteiro.demo.model.Task;
import com.example.jiuteiro.demo.model.User;
import com.example.jiuteiro.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task getTaskById(Long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            return task;
        } else {
            throw new TaskNotFoundException("Task not found by id: " + id);
        }
    }
    public boolean updateStatus(Long id) throws TaskNotFoundException {
        Task task = getTaskById(id);
        if (task == null) {
            return false;
        }
        if (!task.getStatus()) {
            task.setStatus(true);
            taskRepository.save(task);
            return true;
        }
        return false;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task saveTask(TaskRequest taskRequest) {
        Task newTask = new Task(Long.valueOf(0), taskRequest.getTitle(), taskRequest.getStatus());
        return taskRepository.save(newTask);
    }
    public boolean deleteTask(Long id) throws TaskNotFoundException {
        Task findTask = getTaskById(id);
        if (findTask != null) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
