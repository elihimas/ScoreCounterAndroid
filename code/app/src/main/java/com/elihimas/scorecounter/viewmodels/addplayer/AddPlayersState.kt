package com.elihimas.scorecounter.viewmodels.addplayer

import com.elihimas.scorecounter.viewmodels.Player

enum class AddPlayerStep {
    AskAddPlayersOrUseGuest,
    AddPlayers,
    ItemsConfirmation,
    SavingData;

    fun previousStep(): AddPlayerStep = when (this) {
        AskAddPlayersOrUseGuest -> AskAddPlayersOrUseGuest
        AddPlayers -> AskAddPlayersOrUseGuest
        ItemsConfirmation -> AddPlayers
        SavingData -> ItemsConfirmation
    }
}

data class AddPlayersState(
    val currentStep: AddPlayerStep = AddPlayerStep.AskAddPlayersOrUseGuest,
    val players: List<Player> = listOf(),
    val shouldConfirmEmptyItems: Boolean = false,
)
