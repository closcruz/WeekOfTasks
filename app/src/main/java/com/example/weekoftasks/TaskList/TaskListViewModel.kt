package com.example.weekoftasks.TaskList

import androidx.lifecycle.ViewModel
import com.example.weekoftasks.TaskRepository
import com.example.weekoftasks.models.Task

class TaskListViewModel: ViewModel() {

    private val taskRepository = TaskRepository.get()
    val tasksLiveData = taskRepository.getTasks()
}