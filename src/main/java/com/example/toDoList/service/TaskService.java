package com.example.toDoList.service;

import com.example.toDoList.model.Task;
import com.example.toDoList.repository.TaskRepository;
import java.util.Optional;
import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;


    public void ajouterTask(String titre)
    {
        if(titre==null)
        {
            System.out.println("erreur");
        }
        else
        {
            Task task = new Task(titre);
            taskRepository.save(task);
            System.out.println("Ajouté");
        }
    }

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }
    public boolean markTaskCompleted(Long id) {

        Optional<Task> tache = taskRepository.findById(id);

        if(tache.isPresent()) {

            Task task = tache.get();

            if(task.isCompleted()) {
                System.out.println("est complété");
            } else {
                System.out.println("n'est pas complété");
            }

            return task.isCompleted();
        }

        return false;
    }
    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }

}