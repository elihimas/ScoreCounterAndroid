package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elihimas.model.Player

@Composable
fun ColumnScope.Players(players: List<Player>) {
    Box(modifier = Modifier.weight(1f, true)) {
        LazyColumn {
            items(players) { player ->
                Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = player.name)
                    Text(text = player.name)
                }
            }
        }
    }
}
