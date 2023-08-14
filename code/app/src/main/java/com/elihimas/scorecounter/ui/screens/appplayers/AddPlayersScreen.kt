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
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerIntent
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerState
import com.elihimas.scorecounter.viewmodels.addplayer.AddPlayerStep
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddPlayersScreen(state: AddPlayerState, intentHandler: (AddPlayerIntent) -> Unit) {
    val currentPage = when (state.addPlayerStep) {
        AddPlayerStep.AskAddPlayersOrUseGuest -> 0
        AddPlayerStep.AddPlayers -> 1
    }

    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch {
        pagerState.animateScrollToPage(currentPage)
    }

    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> AskAddPlayersOrUseGuest(intentHandler)
            1 -> AddPlayers(state, intentHandler)
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
            AddPlayersScreen(AddPlayerState(), intentHandler = {})
        }
    }
}