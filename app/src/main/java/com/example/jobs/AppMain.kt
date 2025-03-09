package com.example.jobs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core_ui.BottomNavigationBar
import com.example.feature_favorites.FavoriteScreenViewModel
import com.example.jobs.navigation.AppNavHost
import com.example.jobs.navigation.getSelectedIndex
import com.example.jobs.navigation.navigateToScreen

@Composable
internal fun AppMain(
    viewModel: AppMainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val amount by viewModel.favoriteCount.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = getSelectedIndex(currentRoute),
                showBadge = amount != 0,
                numberFavourites = amount,
                onItemSelected = { index ->
                    navigateToScreen(index, navController)
                }
            )
        },
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            AppNavHost(navController)
        }
    }
}
