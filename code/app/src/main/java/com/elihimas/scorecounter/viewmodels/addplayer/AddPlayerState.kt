package com.elihimas.scorecounter.viewmodels.addplayer

import com.elihimas.scorecounter.viewmodels.Player

enum class AddPlayerStep {
    AskAddPlayersOrUseGuest,
    AddPlayers,
}

data class AddPlayerState(
    val addPlayerStep: AddPlayerStep = AddPlayerStep.AskAddPlayersOrUseGuest,
    val players: List<Player> = listOf()
)
