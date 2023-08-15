package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.ui.commons.TwoButtonsRow
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersIntents

@Composable
fun PreviousConfirmControls(intentHandler: (AddPlayersIntents) -> Unit) {
    TwoButtonsRow(
        firstButtonText = stringResource(R.string.button_return),
        secondButtonText = stringResource(R.string.button_confirm),
        firstButtonClick = { intentHandler(AddPlayersIntents.NavigateBack) },
        secondButtonClick = { intentHandler(AddPlayersIntents.Confirm) }
    )
}
