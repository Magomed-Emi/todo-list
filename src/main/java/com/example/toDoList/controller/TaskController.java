package com.example.toDoList.controller;

import com.example.toDoList.model.Task;
import com.example.toDoList.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }


    @PostMapping
    public void ajoutTaches(@RequestParam String titre)
    {
        taskService.ajouterTask(titre);
    }
    @GetMapping
    public List<Task> taches()
    {
        return taskService.getAllTasks();
    }
    @DeleteMapping("/{id}")
    public void deleteTaches(@PathVariable Long id)
    {
        taskService.deleteTask(id);
    }
    @PutMapping("/{id}")
    public void completed(@PathVariable Long id, @RequestParam boolean complete)
    {
        taskService.markTaskCompleted(id, complete);

    }
}