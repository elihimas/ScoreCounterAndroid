package com.elihimas.scorecounter.ui.screens.appplayers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elihimas.scorecounter.ui.screens.appplayers.pages.AddPlayersPage
import com.elihimas.scorecounter.ui.screens.appplayers.pages.AskAddPlayersOrUseGuestPage
import com.elihimas.scorecounter.ui.screens.appplayers.pages.ItemsConfirmationPage
import com.elihimas.scorecounter.ui.screens.appplayers.pages.SavingDataPage
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerStep
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersIntents
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayersState
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddPlayersScreen(state: AddPlayersState, intentHandler: (AddPlayersIntents) -> Unit) {
    val currentPage = when (state.currentStep) {
        AddPlayerStep.AskAddPlayersOrUseGuest -> 0
        AddPlayerStep.AddPlayers -> 1
        AddPlayerStep.ItemsConfirmation -> 2
        AddPlayerStep.SavingData -> 3
    }

    val pagerState = rememberPagerState(pageCount = { AddPlayerStep.values().size })
    val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch {
        pagerState.animateScrollToPage(currentPage)
    }

    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> AskAddPlayersOrUseGuestPage(intentHandler)
            1 -> AddPlayersPage(state, intentHandler)
            2 -> ItemsConfirmationPage(state, intentHandler)
            3 -> SavingDataPage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPlayersScreenPreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AddPlayersScreen(AddPlayersState(currentStep = AddPlayerStep.AddPlayers), intentHandler = {})
        }
    }
}