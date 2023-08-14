package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.Player
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerIntent


@Composable
fun PlayerRow(player: Player, intentHandler: (AddPlayerIntent) -> Unit) {
    Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = player.name)

        Box(modifier = Modifier.weight(1f, true))

        Button(onClick = { /*TODO*/ }) {
            Text(text = "edit")
        }

        Box(modifier = Modifier.width(10.dp))

        Button(onClick = { intentHandler(AddPlayerIntent.RemovePlayer(player)) }) {
            Text(text = "remove")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PlayerRowPreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PlayerRow(Player("Arthur"), intentHandler = {})
        }
    }
}