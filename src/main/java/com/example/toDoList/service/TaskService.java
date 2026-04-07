package com.example.toDoList.service;

import com.example.toDoList.model.Task;
import com.example.toDoList.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void ajouterTask(String titre) {
        if (titre == null) {
            System.out.println("erreur");
        } else {
            Task task = new Task(titre);
            taskRepository.save(task);
            System.out.println("Ajouté");
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public boolean markTaskCompleted(Long id, boolean complete) {
        Optional<Task> tache = taskRepository.findById(id);

        if (tache.isPresent()) {
            Task task = tache.get();
            task.setCompleted(complete);
            taskRepository.save(task);
            return true;
        } else {
            return false;
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}