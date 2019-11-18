package com.example.weekoftasks.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Task (
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var details: String = "",
    var priority: Int = 0,
    var isCompleted: Boolean = false,
    val dateCreated: Date = Date(),
    var deadline: Date = Date()
)