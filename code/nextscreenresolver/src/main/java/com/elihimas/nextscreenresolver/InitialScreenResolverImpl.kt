package com.elihimas.nextscreenresolver

class InitialScreenResolverImpl(private val dataResolver: DataResolver) : InitialScreenResolver {

    override suspend fun findInitialScreen(): InitialScreen {
        val previousGame = dataResolver.getPreviousGameId()

        val initialScreen: InitialScreen = if (previousGame != null) {
            InitialScreen.Game
        } else if (dataResolver.wasPlayersDefined()) {
            InitialScreen.AddGame
        } else {
            InitialScreen.AddPlayers
        }

        return initialScreen
    }
}