package com.android.caffeine.navigation

sealed class Destination(val route: String) {
    object HomeScreen : Destination("homeScreen")
    object WelcomeScreen : Destination("welcomeScreen")
}
