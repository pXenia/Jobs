package com.example.feature_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_db.VacancyEntity
import com.example.core_db.repository.FavoriteRepository
import com.example.core_network.model.Offer
import com.example.core_network.model.Vacancy
import com.example.core_network.repository.GoogleDriveApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val vacancyRepository: GoogleDriveApiRepository,
    private val favoritesRepository: FavoriteRepository
) : ViewModel() {

    private val _vacancies = MutableStateFlow<List<Vacancy>>(emptyList())
    val vacancies: StateFlow<List<Vacancy>> = _vacancies

    private val _offers = MutableStateFlow<List<Offer>>(emptyList())
    val offers: StateFlow<List<Offer>> = _offers

    init {
        loadVacancies()
        loadOffers()
    }

    private fun loadVacancies() {
        viewModelScope.launch {
            _vacancies.value = vacancyRepository.loadVacancies()
            vacancies.value.map {
                if (it.isFavorite)
                    addToFavorites(it)
            }
            compareWithDatabase()
        }
    }

    private fun loadOffers() {
        viewModelScope.launch {
            _offers.value = vacancyRepository.loadOffers()
        }
    }

    fun compareWithDatabase(){
        viewModelScope.launch {
            val favoriteIds = favoritesRepository.getAllFavorites().first().map { it.id }.toSet()
            _vacancies.value = vacancies.value.map {
                it.copy(isFavorite = it.id in favoriteIds)
            }
        }
    }

    fun changeFavorites(vacancy: Vacancy) {
        viewModelScope.launch {
            if (vacancy.isFavorite) {
                favoritesRepository.removeFavoriteById(vacancy.id)
            } else {
                addToFavorites(vacancy)
            }

            _vacancies.update { vacancies ->
                vacancies.map {
                    if (it.id == vacancy.id) it.copy(isFavorite = !vacancy.isFavorite) else it
                }
            }
        }
    }

    private fun addToFavorites(vacancy: Vacancy) {
        viewModelScope.launch {
            favoritesRepository.addFavorite(
                VacancyEntity(
                    id = vacancy.id,
                    numberViewers = vacancy.lookingNumber,
                    jobTitle = vacancy.title,
                    salary = vacancy.salary?.full,
                    city = vacancy.address.town,
                    company = vacancy.company,
                    experience = vacancy.experience.previewText,
                    datePublication = vacancy.publishedDate,
                    isFavourite = true
                )
            )
        }
    }
}