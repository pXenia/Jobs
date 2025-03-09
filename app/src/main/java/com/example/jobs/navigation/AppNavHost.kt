package com.example.jobs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_favorites.FavoritesScreen
import com.example.feature_main.MainScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) { MainScreen() }
        composable(Screen.FavoritesScreen.route) { FavoritesScreen() }
        composable(Screen.ResponsesScreen.route) { ResponsesScreen() }
        composable(Screen.MessagesScreen.route) { MessagesScreen() }
        composable(Screen.ProfileScreen.route) { ProfileScreen() }
    }

}

fun getSelectedIndex(route: String?): Int {
    return when (route) {
        Screen.MainScreen.route -> 0
        Screen.FavoritesScreen.route -> 1
        Screen.ResponsesScreen.route -> 2
        Screen.MessagesScreen.route -> 3
        Screen.ProfileScreen.route -> 4
        else -> 0
    }
}

fun navigateToScreen(index: Int, navController: NavController){
    val route = when (index) {
        0 -> Screen.MainScreen.route
        1 -> Screen.FavoritesScreen.route
        2 -> Screen.ResponsesScreen.route
        3 -> Screen.MessagesScreen.route
        4 -> Screen.ProfileScreen.route
        else -> Screen.MainScreen.route
    }
    navController.navigate(route) {
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

