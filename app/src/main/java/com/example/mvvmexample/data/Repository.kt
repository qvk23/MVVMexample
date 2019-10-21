package com.example.mvvmexample.data

interface Repository {
    suspend fun getPlayers(): List<Player>?
    suspend fun addPlayer(player: Player)
}