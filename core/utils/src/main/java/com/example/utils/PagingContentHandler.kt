package com.example.utils

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

@Composable
fun <T : Any> PagingContentHandler(
    items: LazyPagingItems<T>,
    onError: (Throwable) -> Unit,
    onEmpty: @Composable () -> Unit,
    onLoading: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    when{
        items.loadState.refresh is LoadState.Error -> {
            onError((items.loadState.refresh as LoadState.Error).error)
        }
        items.loadState.append is LoadState.Error -> {
            onError((items.loadState.append as LoadState.Error).error)
        }
        items.loadState.prepend is LoadState.Error -> {
            onError((items.loadState.prepend as LoadState.Error).error)
        }
        items.loadState.refresh is LoadState.Loading -> {
            onLoading()
        }
        items.itemCount == 0 && items.loadState.refresh is LoadState.NotLoading -> {
            onEmpty()
        }
        else -> {
            content()
        }
    }
}