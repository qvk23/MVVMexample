package com.example.mvvmexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao

    companion object {
        val DATABASE_NAME = "player_database"
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries().build().also { INSTANCE = it }
        }
    }
}