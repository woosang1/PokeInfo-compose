package com.example.detail.api

import androidx.navigation.NavController
import com.example.navigation.MainRoute

fun NavController.navigateToDetail(pk: String) {
    navigate(MainRoute.Detail(pk = pk))
}
