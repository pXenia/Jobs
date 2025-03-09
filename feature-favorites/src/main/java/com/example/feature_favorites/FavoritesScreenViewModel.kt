package com.example.feature_favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.core_db.VacancyEntity
import com.example.core_db.repository.FavoriteRepository
import com.example.core_ui.JobCard
import com.example.core_ui.R
import com.example.core_ui.Search
import com.example.core_ui.tools.Dimens
import com.example.core_ui.tools.getVacanciesText
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

    fun changeFavorites(vacancy: VacancyEntity){
        if (vacancy.isFavourite)
            removeFavorite(vacancy.id)
        else
            addToFavorites(vacancy)
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
