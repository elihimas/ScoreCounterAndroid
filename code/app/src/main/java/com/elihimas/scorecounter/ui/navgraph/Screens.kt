package com.elihimas.scorecounter.ui.navgraph

sealed class Screens {
    abstract fun getRoute(): String

    object Splash : Screens() {
        override fun getRoute() = "splash"
    }

    object AddPlayers : Screens() {
        override fun getRoute() = "addPlayers"
    }

    object GamesList : Screens() {
        override fun getRoute() = "gameList"
    }

    object AddGame : Screens() {
        override fun getRoute() = "addGame"
    }

    object Game : Screens() {
        override fun getRoute() = "game"
    }
}