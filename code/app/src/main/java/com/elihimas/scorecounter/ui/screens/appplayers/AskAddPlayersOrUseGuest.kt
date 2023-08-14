package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.ui.theme.FontSizes
import com.elihimas.scorecounter.ui.theme.Modifiers
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerIntent

@Composable
fun AskAddPlayersOrUseGuest(intentHandler: (AddPlayerIntent) -> Unit) {

    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.ask_add_players_or_use_guest),
            fontSize = FontSizes.hugeFont,
            modifier = Modifier.padding(20.dp)
        )

        Box(modifier = Modifier.weight(1f, true))

        Button(modifier = Modifiers.fillWidth,
            onClick = { intentHandler(AddPlayerIntent.UseGuestSelected) }) {
            Text(text = stringResource(R.string.use_guest))
        }

        Button(
            modifier = Modifiers.fillWidth,
            onClick = { intentHandler(AddPlayerIntent.DefinePlayersSelected) }) {
            Text(text = stringResource(R.string.define_player))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AskAddPlayersOrUseGuestPreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            AskAddPlayersOrUseGuest(intentHandler = {})
        }
    }
}