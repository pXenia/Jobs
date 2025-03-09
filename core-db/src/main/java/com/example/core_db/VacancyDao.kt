package com.example.core_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VacancyDao {
    @Query("SELECT * FROM vacancies")
    suspend fun getAllVacancies(): List<VacancyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(videos: List<VacancyEntity>)

    @Query("DELETE FROM vacancies WHERE id = :vacancyId")
    suspend fun removeFavorite(vacancyId: String)

    @Query("SELECT COUNT(*) FROM vacancies")
    fun getFavoriteCount(): Flow<Int>
}