package com.example.weekoftasks

import android.content.Context
import androidx.room.Room
import com.example.weekoftasks.database.TaskDatabase
import com.example.weekoftasks.models.Task
import java.lang.IllegalStateException
import java.util.*

private const val DB_NAME = "task-database"

class TaskRepository private constructor(context: Context) {

    private val db: TaskDatabase = Room.databaseBuilder(
        context.applicationContext,
        TaskDatabase::class.java,
        DB_NAME
    ).build()

    private  val taskDao = db.taskDao()

    fun getTasks(): List<Task> = taskDao.getTasks()
    fun getTask(id: UUID): Task? = taskDao.getTask(id)

    companion object {
        private var INSTANCE: TaskRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TaskRepository(context)
            }
        }

        fun get(): TaskRepository {
            return INSTANCE ?:
                    throw IllegalStateException("TaskRepository must be initialize")
        }
    }
}