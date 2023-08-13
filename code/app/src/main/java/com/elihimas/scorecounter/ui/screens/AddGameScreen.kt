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
fun AddGameScreen() {
    Text(text = "add game")
}

@Preview(showBackground = true)
@Composable
fun AddGameScreenPreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AddGameScreen()
        }
    }
}