package com.elihimas.repository

import com.elihimas.model.Player
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun savePlayers(players: List<Player>)
    suspend fun allPlayers(): Flow<List<Player>>
}