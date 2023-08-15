package com.elihimas.scorecounter.viewmodels.addplayer


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elihimas.scorecounter.viewmodels.Player
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddPlayerViewModel : ViewModel() {

    private val _state = MutableStateFlow(AddPlayersState())
    val state = _state.asStateFlow()

    private val _messages = MutableSharedFlow<AddPlayerMessages>()
    val messages = _messages.asSharedFlow()

    fun handleIntent(intent: AddPlayersIntents) {
        when (intent) {
            AddPlayersIntents.DefinePlayersSelected -> handleDefinePlayersSelected()
            AddPlayersIntents.UseGuestSelected -> handleUseGuestSelected()
            AddPlayersIntents.NavigateBack -> handleNavigateBack()
            AddPlayersIntents.Finish -> handleFinish()
            AddPlayersIntents.Confirm -> handleConfirm()
            AddPlayersIntents.ConfirmEmptyItems.Confirm -> handleConfirmEmptyItems()
            AddPlayersIntents.ConfirmEmptyItems.Dismiss -> handleDismissEmptyItems()
            is AddPlayersIntents.AddPlayer -> handleAddPlayer(intent)
            is AddPlayersIntents.EditPlayer -> handleEditPlayer(intent)
            is AddPlayersIntents.RemovePlayer -> handleRemovePlayer(intent)
        }
    }

    private fun handleConfirm() {
        _state.update { previousState ->
            previousState.copy(currentStep = AddPlayerStep.SavingData)
        }

        viewModelScope.launch {
            delay(1000)
            _messages.emit(AddPlayerMessages.NavigateToGames)
        }

    }

    private fun handleDefinePlayersSelected() = _state.update { previousState ->
        previousState.copy(currentStep = AddPlayerStep.AddPlayers)
    }

    private fun handleUseGuestSelected() = _state.update { previousState ->
        previousState.copy()
    }

    private fun handleNavigateBack() {
        _state.update { previousState ->
            val previousStep = previousState.currentStep.previousStep()

            previousState.copy(currentStep = previousStep)
        }
    }

    private fun handleFinish() {
        val hasPlayers = _state.value.players.isNotEmpty()

        if (hasPlayers) {
            _state.update { previousState ->
                previousState.copy(currentStep = AddPlayerStep.ItemsConfirmation)
            }
        } else {
            _state.update { previousState ->
                previousState.copy(shouldConfirmEmptyItems = true)
            }
        }
    }

    private fun handleConfirmEmptyItems() {
        // TODO mark as using guest
        viewModelScope.launch {
            _messages.emit(AddPlayerMessages.NavigateToGames)
        }
    }

    private fun handleDismissEmptyItems() {
        _state.update { previousState ->
            previousState.copy(shouldConfirmEmptyItems = false)
        }
    }

    private fun handleAddPlayer(addPlayerIntents: AddPlayersIntents.AddPlayer) {
        val newName = addPlayerIntents.newPlayerName.trim()
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

    private fun handleEditPlayer(editPlayerIntent: AddPlayersIntents.EditPlayer) =
        updatePlayers { players ->
            players.toMutableList().apply {
                this[editPlayerIntent.playerPosition] = Player(editPlayerIntent.newName)
            }
        }

    private fun handleRemovePlayer(removePlayerIntent: AddPlayersIntents.RemovePlayer) =
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
