package com.example.jobs.navigation

sealed class Screen(
    val route: String,
) {
    object MainScreen : Screen("main_screen")
    object MainDetailsScreen : Screen("main_details_screen")
    object FavoritesScreen : Screen("favorites_screen")
    object ResponsesScreen : Screen("responses_screen")
    object MessagesScreen : Screen("messages_screen")
    object ProfileScreen : Screen("profile_screen")
}