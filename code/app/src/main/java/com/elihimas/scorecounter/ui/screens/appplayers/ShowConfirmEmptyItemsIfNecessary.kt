package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersIntents
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersState

@Composable
fun ShowConfirmEmptyItemsIfNecessary(
    state: AddPlayersState,
    intentHandler: (AddPlayersIntents) -> Unit
) {
    if (state.shouldConfirmEmptyItems) {
        AlertDialog(
            onDismissRequest = {
            },
            dismissButton = {
                Button(onClick = { intentHandler(AddPlayersIntents.ConfirmEmptyItems.Dismiss) }) {
                    Text(text = stringResource(R.string.button_cancel))
                }
            }, confirmButton = {
                Button(onClick = { intentHandler(AddPlayersIntents.ConfirmEmptyItems.Confirm) }) {
                    Text(text = stringResource(R.string.button_confirm))
                }
            },
            text = {
                Text(
                    text =
                    stringResource(R.string.message_confirm_empty_players)
                )
            }
        )
    }
}
