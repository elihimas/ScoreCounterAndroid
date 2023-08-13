package com.elihimas.scorecounter.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme

@Composable
fun AddPlayersScreen() {
    Text(text = "add player")
}

@Preview(showBackground = true)
@Composable
fun AddPlayersScreenPreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AddPlayersScreen()
        }
    }
}