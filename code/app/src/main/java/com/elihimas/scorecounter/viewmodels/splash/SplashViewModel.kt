package com.elihimas.scorecounter.viewmodels.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elihimas.nextscreenresolver.InitialScreen
import com.elihimas.nextscreenresolver.InitialScreenResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val initialScreenResolver: InitialScreenResolver) :
    ViewModel() {

    private val _initialScreen = Channel<InitialScreen>()
    val initialScreen: Flow<InitialScreen> = _initialScreen.consumeAsFlow()

    init {
        resolveNextScreen()
    }

    private fun resolveNextScreen() {
        viewModelScope.launch {
            val deferredNextScreen = async { initialScreenResolver.findInitialScreen() }

            delay(splashDuration)

            val initialScreen = deferredNextScreen.await()
            _initialScreen.send(initialScreen)
        }
    }

    private companion object {
        const val splashDuration = 1200L
    }
}