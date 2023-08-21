package com.elihimas.nextscreenresolver

import com.elihimas.repository.ScoreCounterDAO

class DataResolverImpl(private val dao: ScoreCounterDAO) : DataResolver {
    override suspend fun getPreviousGameId(): Int? {
        // TODO: create an actual implementation for this
        return null
    }

    override suspend fun wasPlayersDefined(): Boolean {
        return dao.hasPlayers()
    }

}