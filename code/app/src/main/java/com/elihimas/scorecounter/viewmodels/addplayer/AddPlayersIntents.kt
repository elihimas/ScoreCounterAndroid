package com.elihimas.scorecounter.viewmodels.addplayer

import com.elihimas.scorecounter.viewmodels.Player

sealed class AddPlayersIntents {
    object UseGuestSelected : AddPlayersIntents()
    object DefinePlayersSelected : AddPlayersIntents()
    data class AddPlayer(val newPlayerName: String) : AddPlayersIntents()
    data class RemovePlayer(val player: Player) : AddPlayersIntents()
    data class EditPlayer(val newName: String, val playerPosition: Int) : AddPlayersIntents()
    object NavigateBack : AddPlayersIntents()
    object Finish : AddPlayersIntents()

    object Confirm : AddPlayersIntents()

    object ConfirmEmptyItems {
        object Dismiss : AddPlayersIntents()
        object Confirm : AddPlayersIntents()
    }
}
