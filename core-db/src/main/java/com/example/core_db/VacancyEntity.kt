package com.example.core_db

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "vacancies")
data class VacancyEntity(
    @PrimaryKey val id: Int,
    val numberViewers: Int?,
    val jobTitle: String,
    val salary: String?,
    val city: String,
    val company: String,
    val experience: String,
    val datePublication: String,
    val isFavourite: Boolean,
)
