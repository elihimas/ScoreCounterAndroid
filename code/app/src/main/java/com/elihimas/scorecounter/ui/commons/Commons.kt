package com.elihimas.scorecounter.ui.commons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elihimas.scorecounter.ui.theme.FontSizes

@Composable
fun PageTitle(title: String) {
    Text(
        text = title,
        fontSize = FontSizes.huge,
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun Centered(content: @Composable () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}