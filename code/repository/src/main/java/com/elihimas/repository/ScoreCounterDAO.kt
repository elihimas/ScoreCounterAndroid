package com.elihimas.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elihimas.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreCounterDAO {

    @Query("SELECT * from Player")
    fun allPlayers(): Flow<List<Player>>

    @Query("SELECT COUNT(id) FROM Player")
    suspend fun hasPlayers(): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePlayers(characters: List<Player>)
}
