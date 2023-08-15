package com.elihimas.scorecounter.ui.navgraph

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elihimas.nextscreenresolver.InitialScreen
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.ui.screens.AddGameScreen
import com.elihimas.scorecounter.ui.screens.GameScreen
import com.elihimas.scorecounter.ui.screens.GamesListScreen
import com.elihimas.scorecounter.ui.screens.SplashScreen
import com.elihimas.scorecounter.ui.screens.appplayers.AddPlayersScreen
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerMessages
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersState
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Splash.getRoute()) {
        composable(Screens.Splash.getRoute()) {
            val initialScreenNavigator: (InitialScreen) -> Unit = { nextScreen ->
                navController.popBackStack()
                navController.navigate(nextScreen.toScreen().getRoute())
            }

            SplashScreen(onInitialScreenResolved = initialScreenNavigator)
        }

        composable(Screens.AddPlayers.getRoute()) {
            val viewModel: AddPlayerViewModel = hiltViewModel()
            val state = viewModel.state.collectAsState(initial = AddPlayersState()).value
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                viewModel.messages.collectLatest { addPlayerMessage ->
                    when (addPlayerMessage) {
                        AddPlayerMessages.RepeatedPlayer -> showRepeatedPlayer(context)
                        AddPlayerMessages.NavigateToGames -> {
                            navController.popBackStack()
                            navController.navigate(Screens.GamesList.getRoute())
                        }
                    }
                }
            }

            AddPlayersScreen(state, viewModel::handleIntent)
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

fun showRepeatedPlayer(context: Context) {
    Toast.makeText(
        context,
        R.string.message_repeated_player,
        Toast.LENGTH_LONG
    ).show()
}

private fun InitialScreen.toScreen() = when (this) {
    InitialScreen.AddPlayers -> Screens.AddPlayers
    InitialScreen.AddGame -> Screens.AddGame
    InitialScreen.Game -> Screens.Game
}
