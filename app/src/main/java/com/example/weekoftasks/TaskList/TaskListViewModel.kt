package com.example.weekoftasks.TaskList

import androidx.lifecycle.ViewModel
import com.example.weekoftasks.models.Task

class TaskListViewModel: ViewModel() {
    val tasks = mutableListOf<Task>()

    init {
        for (i in 0 until 100) {
            val task = Task()
            task.title = "Task #$i"
            task.details = "This is a dummy task"
            task.isCompleted = i % 2 == 0
            tasks += task
        }
    }
}