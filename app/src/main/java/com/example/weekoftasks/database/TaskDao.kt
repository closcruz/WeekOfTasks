package com.example.weekoftasks.database

import androidx.room.Dao
import androidx.room.Query
import com.example.weekoftasks.models.Task
import java.util.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getTasks(): List<Task>

    @Query("SELECT * FROM task WHERE id=(:id)")
    fun getTask(id: UUID): Task?
}