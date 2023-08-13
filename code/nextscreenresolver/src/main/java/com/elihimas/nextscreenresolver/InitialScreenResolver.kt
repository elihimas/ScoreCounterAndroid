package com.elihimas.nextscreenresolver

interface InitialScreenResolver {
    suspend fun findInitialScreen(): InitialScreen
}