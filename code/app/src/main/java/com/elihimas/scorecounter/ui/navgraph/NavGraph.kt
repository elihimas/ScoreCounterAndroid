package com.elihimas.scorecounter.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elihimas.scorecounter.ui.na.AddPlayersScreen
import com.elihimas.scorecounter.ui.sc.AddGameScreen
import com.elihimas.scorecounter.ui.screens.GameScreen
import com.elihimas.scorecounter.ui.screens.GamesListScreen
import com.elihimas.scorecounter.ui.screens.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Splash.getRoute()) {
        composable(Screens.Splash.getRoute()) {
            SplashScreen()
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