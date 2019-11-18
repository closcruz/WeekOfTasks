package com.example.weekoftasks.database

import androidx.room.TypeConverter
import java.util.*

class TaskTypeConverter {

    @TypeConverter
    fun toUUID(uuid: String?): UUID {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }

    @TypeConverter
    fun toDate(msSinceEpoch: Long?): Date? {
        return msSinceEpoch?.let {
            Date(it)
        }
    }

    @TypeConverter
    fun fromDate8(date: Date?): Long? {
        return date?.time
    }
}