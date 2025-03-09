package com.example.feature_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_network.model.Offer
import com.example.core_network.model.Vacancy
import com.example.core_network.repository.GoogleDriveApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: GoogleDriveApiRepository,
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
            _vacancies.value = repository.loadVacancies()
        }
    }

    private fun loadOffers() {
        viewModelScope.launch {
            _offers.value = repository.loadOffers()
        }
    }

}