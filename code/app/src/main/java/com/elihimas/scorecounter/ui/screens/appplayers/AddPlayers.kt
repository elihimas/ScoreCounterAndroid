package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.ui.theme.FontSizes
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.Player
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerIntent
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlayers(state: AddPlayerState, intentHandler: (AddPlayerIntent) -> Unit) {
    var newPlayerName by remember { mutableStateOf("") }

    Column {
        Text(
            text = stringResource(R.string.title_add_players_screen),
            fontSize = FontSizes.hugeFont,
            modifier = Modifier.padding(20.dp)
        )

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

        Row {
            TextField(value = newPlayerName, onValueChange = { newPlayerName = it })

            Button(onClick = {
                intentHandler(AddPlayerIntent.AddPlayer(newPlayerName))
                newPlayerName = ""
            }) {
                Text(text = stringResource(R.string.button_add))
            }
        }
    }
}

@Composable
fun ShowNoPlayers() {
    Text(text = stringResource(R.string.message_no_players))
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
            AddPlayers(AddPlayerState(players = players), intentHandler = {})
        }
    }
}