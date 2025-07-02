package com.android.caffeine.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.android.caffeine.screens.HomeScreen
import com.android.caffeine.screens.WelcomeScreen

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(Destination.HomeScreen.route){
        HomeScreen(navController = navController)

    }
}

fun NavGraphBuilder.welcomeScreen(navController: NavHostController) {
    composable(Destination.WelcomeScreen.route){
        WelcomeScreen(navController = navController)

    }
}