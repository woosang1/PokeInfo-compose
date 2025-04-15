package com.example.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.designsystem.theme.PokeInfoTheme
import com.example.utils.UiError
import com.example.utils.extension.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import com.example.utils.log.DebugLog

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                PokeInfoTheme {
                    val snackBarHostState = remember { SnackbarHostState() }
                    val coroutineScope = rememberCoroutineScope()

                    val onHandleNetworkUI: (Throwable?) -> Unit = { throwable ->
                        coroutineScope.launch {
                            val uiError = when (throwable) {
                                is HttpException -> when (throwable.code()) {
                                    401 -> UiError.AuthError()
                                    403 -> UiError.PermissionError()
                                    else -> UiError.ServerError(throwable.code(), throwable.message ?: "")
                                }
                                is IOException -> UiError.NetworkError()
                                else -> UiError.UnknownError("알 수 없는 오류 발생: ${throwable?.message}")
                            }
                            snackBarHostState.showSnackbar(uiError.message)
                        }
                    }
                    MainScreen(
                        modifier = Modifier,
                        onHandleNetworkUI = onHandleNetworkUI,
                        snackBarHostState = snackBarHostState
                    )
                }
            }
        }
    }
}

