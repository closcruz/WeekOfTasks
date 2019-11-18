package com.example.weekoftasks.models

import java.util.*

data class Task (
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var details: String = "",
    var priority: Int = 0,
    var isCompleted: Boolean = false,
    val dateCreated: Date = Date(),
    var deadline: Date = Date()
)