package com.elihimas.scorecounter.ui.screens.appplayers.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.elihimas.model.Player
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.ui.commons.Centered
import com.elihimas.scorecounter.ui.commons.PageTitle
import com.elihimas.scorecounter.ui.screens.appplayers.AddPlayerControls
import com.elihimas.scorecounter.ui.screens.appplayers.PlayerRow
import com.elihimas.scorecounter.ui.screens.appplayers.PreviousFinishControls
import com.elihimas.scorecounter.ui.screens.appplayers.ShowConfirmEmptyItemsIfNecessary
import com.elihimas.scorecounter.ui.theme.FontSizes
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersIntents
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersState

@Composable
fun AddPlayersPage(state: AddPlayersState, intentHandler: (AddPlayersIntents) -> Unit) {

    ShowConfirmEmptyItemsIfNecessary(state, intentHandler)

    Column {
        PageTitle(stringResource(R.string.title_add_players_screen))

        Box(modifier = Modifier.weight(1f, true)) {
            if (state.players.isEmpty()) {
                ShowNoPlayers()
            } else {
                LazyColumn {
                    items(state.players) { player ->
                        PlayerRow(player, intentHandler)
                    }
                }
            }
        }

        AddPlayerControls(intentHandler)

        Divider()

        PreviousFinishControls(intentHandler)
    }
}

@Composable
fun ShowNoPlayers() {
    Centered {
        Text(text = stringResource(R.string.message_no_players), fontSize = FontSizes.big)
    }
}

@Preview(showBackground = true)
@Composable
fun AddPlayersPreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val players = listOf(Player("Arthur"), Player("João"))
            AddPlayersPage(
                AddPlayersState(players = players),
                intentHandler = {})
        }
    }
}