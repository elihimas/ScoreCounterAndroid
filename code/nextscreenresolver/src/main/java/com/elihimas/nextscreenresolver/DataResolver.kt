package com.elihimas.nextscreenresolver

interface DataResolver {
    suspend fun getPreviousGameId(): Int?
    suspend fun wasPlayersDefined(): Boolean
}