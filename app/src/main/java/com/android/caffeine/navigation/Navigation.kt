package com.android.caffeine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun CaffeinneNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen.route
    ) {
        homeScreen(navController = navController)
        welcomeScreen(navController = navController)
    }
}

