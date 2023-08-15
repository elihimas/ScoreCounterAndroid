package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersIntents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlayerControls(intentHandler: (AddPlayersIntents) -> Unit) {
    var newPlayerName by remember { mutableStateOf("") }

    Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
        TextField(
            colors = TextFieldDefaults.textFieldColors(
            ),
            modifier = Modifier.weight(1f, true),

            value = newPlayerName, onValueChange = { newPlayerName = it })

        Spacer(modifier = Modifier.width(10.dp))

        Button(onClick = {
            intentHandler(AddPlayersIntents.AddPlayer(newPlayerName))
            newPlayerName = ""
        }) {
            Text(text = stringResource(R.string.button_add))
        }
    }
}
