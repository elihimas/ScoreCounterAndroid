package com.elihimas.scorecounter.di

import com.elihimas.nextscreenresolver.DataResolver
import com.elihimas.nextscreenresolver.InitialScreenResolver
import com.elihimas.nextscreenresolver.InitialScreenResolverImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SplashViewModelModule {

    @Provides
    fun provideNextScreenResolver(): InitialScreenResolver {
        // TODO: create a actual implementation for this resolver
        val dataResolver = object : DataResolver {
            override suspend fun getPreviousGameId() = null

            override suspend fun wasPlayersDefined() = false

        }
        return InitialScreenResolverImpl(dataResolver)
    }

}