package com.elihimas.scorecounter.viewmodels.addplayer

import com.elihimas.model.Player

sealed class AddPlayersIntents {
    object UseGuestSelected : AddPlayersIntents()
    object DefinePlayersSelected : AddPlayersIntents()
    data class AddPlayer(val newPlayerName: String) : AddPlayersIntents()
    data class RemovePlayer(val player: Player) : AddPlayersIntents()
    data class EditPlayer(val newName: String, val playerPosition: Int) : AddPlayersIntents()
    object NavigateBack : AddPlayersIntents()
    object NavigateNext : AddPlayersIntents()

    object Confirm : AddPlayersIntents()

    object ConfirmEmptyItems {
        object Dismiss : AddPlayersIntents()
        object Confirm : AddPlayersIntents()
    }
}
