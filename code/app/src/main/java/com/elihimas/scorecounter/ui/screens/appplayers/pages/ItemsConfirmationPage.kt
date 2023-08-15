package com.elihimas.scorecounter.ui.screens.appplayers.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.ui.commons.PageTitle
import com.elihimas.scorecounter.ui.screens.appplayers.Players
import com.elihimas.scorecounter.ui.screens.appplayers.PreviousConfirmControls
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.Player
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersIntents
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersState

@Composable
fun ItemsConfirmationPage(state: AddPlayersState, intentHandler: (AddPlayersIntents) -> Unit) {
    Column {
        PageTitle(stringResource(R.string.title_confirmation))

        Players(state.players)

        PreviousConfirmControls(intentHandler)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemsConfirmationPagePreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val players =
                listOf(Player("Arthur"), Player("João"), Player("Aurélio"), Player("Aziz"))
            ItemsConfirmationPage(AddPlayersState(players = players), intentHandler = {})
        }
    }
}