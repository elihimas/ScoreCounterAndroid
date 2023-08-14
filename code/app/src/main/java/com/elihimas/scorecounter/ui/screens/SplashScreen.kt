package com.elihimas.scorecounter.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elihimas.nextscreenresolver.InitialScreen
import androidx.compose.runtime.getValue
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.splash.SplashViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onInitialScreenResolved: (InitialScreen) -> Unit
) {
    Text(text = "Splash")

    val initialScreen = viewModel.initialScreen.collectAsState(initial = null).value

    initialScreen?.let { initialScreen ->
        onInitialScreenResolved(initialScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SplashScreen(hiltViewModel(), onInitialScreenResolved = { _ -> })
        }
    }
}