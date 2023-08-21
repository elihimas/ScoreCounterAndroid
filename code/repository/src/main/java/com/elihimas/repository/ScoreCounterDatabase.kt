package com.elihimas.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elihimas.model.Player

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class ScoreCounterDatabase : RoomDatabase() {

    abstract fun dao(): ScoreCounterDAO

    companion object {
        fun createDao(context: Context) =
            Room.databaseBuilder(
                context,
                ScoreCounterDatabase::class.java,
                "ScoreCounterDatabase"
            ).build().dao()
    }
}
