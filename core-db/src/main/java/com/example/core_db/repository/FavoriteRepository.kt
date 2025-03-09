package com.example.core_db.repository

import com.example.core_db.VacancyDao
import com.example.core_db.VacancyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class FavoriteRepository @Inject constructor(
    private val vacancyDao: VacancyDao
) {
    fun getAllFavorites(): Flow<List<VacancyEntity>> = flow {
        emit(vacancyDao.getAllVacancies())
    }

    suspend fun addFavorite(vacancy: VacancyEntity) {
        vacancyDao.addFavorite(listOf(vacancy))
    }

    suspend fun removeFavoriteById(vacancyId: String) {
        vacancyDao.removeFavorite(vacancyId)
    }
}
