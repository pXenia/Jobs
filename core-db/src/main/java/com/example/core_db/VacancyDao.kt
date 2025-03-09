package com.example.core_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VacancyDao {
    @Query("SELECT * FROM vacancies")
    suspend fun getAllVideos(): List<VacancyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(videos: List<VacancyEntity>)

    @Query("DELETE FROM vacancies WHERE id = :vacancyId")
    suspend fun removeFavorite(vacancyId: Int)
}