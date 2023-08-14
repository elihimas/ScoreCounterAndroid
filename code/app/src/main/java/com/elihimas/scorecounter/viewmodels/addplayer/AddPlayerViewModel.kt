package com.elihimas.scorecounter.viewmodels.addplayer


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elihimas.scorecounter.viewmodels.Player
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddPlayerViewModel : ViewModel() {

    private val _state = MutableStateFlow(AddPlayerState())
    val state = _state.asStateFlow()

    private val _messages = MutableSharedFlow<AddPlayerMessages>()
    val messages = _messages.asSharedFlow()

    fun handleIntent(intent: AddPlayerIntent) {
        when (intent) {
            AddPlayerIntent.DefinePlayersSelected -> handleDefinePlayersSelected()
            AddPlayerIntent.UseGuestSelected -> handleUseGuestSelected()
            is AddPlayerIntent.AddPlayer -> handleAddPlayer(intent)
            is AddPlayerIntent.EditPlayer -> handleEditPlayer(intent)
            is AddPlayerIntent.RemovePlayer -> handleRemovePlayer(intent)
        }
    }

    private fun handleDefinePlayersSelected() = _state.update { previousState ->
        previousState.copy(addPlayerStep = AddPlayerStep.AddPlayers)
    }

    private fun handleUseGuestSelected() = _state.update { previousState ->
        previousState.copy()
    }

    private fun handleAddPlayer(addPlayerIntent: AddPlayerIntent.AddPlayer) {
        val newName = addPlayerIntent.newPlayerName.trim()
        val isRepeatedPlayer = _state.value.players.any { it.name == newName }

        if (isRepeatedPlayer) {
            viewModelScope.launch {
                _messages.emit(AddPlayerMessages.RepeatedPlayer)
            }
        } else if (newName.isNotEmpty()) {
            addPlayer(Player(newName))
        }
    }

    private fun addPlayer(player: Player) {
        updatePlayers { players ->
            players.toMutableList()
                .apply { add(player) }
        }
    }

    private fun handleEditPlayer(editPlayerIntent: AddPlayerIntent.EditPlayer) =
        updatePlayers { players ->
            players.toMutableList().apply {
                this[editPlayerIntent.playerPosition] = Player(editPlayerIntent.newName)
            }
        }

    private fun handleRemovePlayer(removePlayerIntent: AddPlayerIntent.RemovePlayer) =
        updatePlayers { players ->
            players.toMutableList().apply {
                remove(removePlayerIntent.player)
            }
        }


    private fun updatePlayers(listUpdater: (List<Player>) -> List<Player>) {
        _state.update { previousState ->
            val newPlayersList = listUpdater(previousState.players)

            previousState.copy(
                players = newPlayersList
            )
        }
    }
}
