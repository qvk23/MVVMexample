package com.example.mvvmexample.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImp(private val playerDao: PlayerDao): Repository {
    override suspend fun getPlayers(): List<Player>? = withContext(Dispatchers.IO) {
        return@withContext playerDao.getPlayers()
    }

    override suspend fun addPlayer(player: Player) = withContext(Dispatchers.IO) {
        return@withContext playerDao.addPlayer(player)
    }
}
