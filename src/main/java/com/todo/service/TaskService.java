package com.todo.service;

import com.todo.entity.Task;
import com.todo.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo taskRepo;


    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    public void createTask(String title){
        Task task = new Task();
        task.setCompleted(false);
        task.setTitle(title);
        taskRepo.save(task);
    }

    public void deleteTask(long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(long id){
        Task task= taskRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
        task.setCompleted(!task.isCompleted());
        taskRepo.save(task);

    }
}
