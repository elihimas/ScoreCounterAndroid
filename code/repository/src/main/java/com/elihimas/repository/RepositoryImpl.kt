package com.elihimas.repository

import com.elihimas.model.Player
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dao: ScoreCounterDAO
) : Repository {

    override suspend fun savePlayers(players: List<Player>) {
        dao.savePlayers(players)
    }

    override suspend fun allPlayers(): Flow<List<Player>> = dao.allPlayers()
}
