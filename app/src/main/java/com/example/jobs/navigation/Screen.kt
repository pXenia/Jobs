package com.example.jobs.navigation

sealed class Screen(
    val route: String,
) {
    object MainScreen: Screen("player")
    object FavoritesScreen: Screen("videos")
    object ResponsesScreen: Screen("responses_screen")
    object MessagesScreen: Screen("messages_screen")
    object ProfileScreen: Screen("profile_screen")
}