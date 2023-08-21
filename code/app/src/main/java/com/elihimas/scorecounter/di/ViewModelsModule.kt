package com.elihimas.scorecounter.di

import com.elihimas.nextscreenresolver.DataResolver
import com.elihimas.nextscreenresolver.DataResolverImpl
import com.elihimas.nextscreenresolver.InitialScreenResolver
import com.elihimas.nextscreenresolver.InitialScreenResolverImpl
import com.elihimas.repository.Repository
import com.elihimas.repository.RepositoryImpl
import com.elihimas.repository.ScoreCounterDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelsModule {

    @Provides
    fun provideNextScreenResolver(dataResolver: DataResolver): InitialScreenResolver {
        return InitialScreenResolverImpl(dataResolver)
    }
    @Provides
    fun provideDataResolver(dao:ScoreCounterDAO): DataResolver {
        return DataResolverImpl(dao)
    }

    @Provides
    fun provideRepository(dao: ScoreCounterDAO): Repository {
        return RepositoryImpl(dao)
    }
}