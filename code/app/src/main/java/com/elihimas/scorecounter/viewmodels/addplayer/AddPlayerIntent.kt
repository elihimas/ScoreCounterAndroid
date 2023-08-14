package com.elihimas.scorecounter.viewmodels.addplayer

import com.elihimas.scorecounter.viewmodels.Player

sealed class AddPlayerIntent {
    object UseGuestSelected : AddPlayerIntent()
    object DefinePlayersSelected : AddPlayerIntent()
    data class AddPlayer(val newPlayerName: String) : AddPlayerIntent()
    data class RemovePlayer(val player: Player) : AddPlayerIntent()
    data class EditPlayer(val newName: String, val playerPosition: Int) : AddPlayerIntent()
}
