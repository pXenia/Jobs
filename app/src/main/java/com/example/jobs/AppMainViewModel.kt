package com.example.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_db.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppMainViewModel @Inject constructor(
    private val repository: FavoriteRepository
) : ViewModel() {

    private val _favoriteCount = MutableStateFlow(0)
    val favoriteCount: StateFlow<Int> = _favoriteCount.asStateFlow()

    init {
        loadFavoriteCount()
    }

    private fun loadFavoriteCount() {
        viewModelScope.launch {
            repository.getFavoriteCountFlow().collect { count ->
                _favoriteCount.value = count
            }
        }
    }
}