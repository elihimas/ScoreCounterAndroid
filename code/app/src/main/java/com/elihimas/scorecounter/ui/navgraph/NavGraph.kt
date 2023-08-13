package com.elihimas.scorecounter.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elihimas.nextscreenresolver.InitialScreen
import com.elihimas.scorecounter.ui.screens.AddPlayersScreen
import com.elihimas.scorecounter.ui.screens.AddGameScreen
import com.elihimas.scorecounter.ui.screens.GameScreen
import com.elihimas.scorecounter.ui.screens.GamesListScreen
import com.elihimas.scorecounter.ui.screens.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Splash.getRoute()) {
        composable(Screens.Splash.getRoute()) {
            val nextScreenNavigator: (InitialScreen) -> Unit = { nextScreen->
                navController.popBackStack()
                navController.navigate(nextScreen.toScreen().getRoute())
            }

            SplashScreen(hiltViewModel(), nextScreenNavigator)
        }

        composable(Screens.AddPlayers.getRoute()) {
            AddPlayersScreen()
        }

        composable(Screens.GamesList.getRoute()) {
            GamesListScreen()
        }


        composable(Screens.AddGame.getRoute()) {
            AddGameScreen()
        }

        composable(Screens.Game.getRoute()) {
            GameScreen()
        }
    }
}

private fun InitialScreen.toScreen() = when (this) {
    InitialScreen.AddPlayers -> Screens.AddPlayers
    InitialScreen.AddGame -> Screens.AddGame
    InitialScreen.Game -> Screens.Game
}
