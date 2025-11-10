package com.example.home.api

import androidx.navigation.NavController
import com.example.navigation.MainRoute

fun NavController.navigateToHome() {
    navigate(MainRoute.Home)
}
