package com.elihimas.scorecounter.di

import android.app.Application
import com.elihimas.repository.ScoreCounterDAO
import com.elihimas.repository.ScoreCounterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun providesScoreCounterDAO(application: Application): ScoreCounterDAO {
        return ScoreCounterDatabase.createDao(application)
    }
}