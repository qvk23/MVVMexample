package com.example.mvvmexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayerDao {
    @Insert
    suspend fun addPlayer(player: Player)
    @Query("SELECT * FROM player")
    suspend fun getPlayers(): List<Player>?
}