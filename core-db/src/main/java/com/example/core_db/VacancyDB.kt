package com.example.core_db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [VacancyEntity::class], version = 1)
abstract class VacancyDB : RoomDatabase() {
    abstract fun vacancyDao(): VacancyDao
}