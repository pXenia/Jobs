package com.example.feature_favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_db.VacancyEntity
import com.example.core_db.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteScreenViewModel @Inject constructor(
    private val repository: FavoriteRepository
) : ViewModel() {

    private val _favoriteVacancies = MutableStateFlow<List<VacancyEntity>>(emptyList())
    val favoriteVacancies: StateFlow<List<VacancyEntity>> = _favoriteVacancies

    init {
        loadFavorites()
    }

    fun changeFavorites(vacancy: VacancyEntity) {
        if (vacancy.isFavourite) removeFavorite(vacancy.id)
        else addToFavorites(vacancy)
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            repository.getAllFavorites().collect { vacancies ->
                _favoriteVacancies.value = vacancies
            }
        }
    }

    private fun addToFavorites(vacancy: VacancyEntity) {
        viewModelScope.launch {
            repository.addFavorite(vacancy.copy(isFavourite = true))
            loadFavorites()
        }
    }

    private fun removeFavorite(vacancyId: String) {
        viewModelScope.launch {
            repository.removeFavoriteById(vacancyId)
            loadFavorites()
        }
    }
}
