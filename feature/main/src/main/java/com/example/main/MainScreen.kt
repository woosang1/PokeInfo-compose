package com.example.main

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    modifier: Modifier,
    onHandleNetworkUI: (Throwable?) -> Unit = { throwable -> },
    snackBarHostState: SnackbarHostState
){
    Scaffold(
        modifier = modifier,
        content = { padding ->
            MainNavHost(onHandleNetworkUI = onHandleNetworkUI)
        },
        bottomBar = {

        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    )
}

