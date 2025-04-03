package com.example.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors

@Composable
internal fun FloatingButton(
    modifier: Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        modifier = modifier.size(56.dp),
        onClick = { onClick() },
        containerColor = LocalColors.current.lightBlue,
        contentColor = LocalColors.current.white
    ) {
        Image(
            painter = painterResource(id = com.example.ui.R.drawable.filter),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp),
            contentScale = ContentScale.Fit
        )
    }
}