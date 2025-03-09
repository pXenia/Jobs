package com.example.jobs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core_ui.BottomNavigationBar
import com.example.jobs.navigation.AppNavHost
import com.example.jobs.navigation.getSelectedIndex
import com.example.jobs.navigation.navigateToScreen
import com.example.jobs.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                AppMain()
            }
        }
    }
}

@Composable
private fun AppMain() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = getSelectedIndex(currentRoute),
                onItemSelected = { index ->
                    navigateToScreen(index, navController)
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .systemBarsPadding()
        ) {
            AppNavHost(navController)
        }
    }
}
