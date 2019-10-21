package com.example.mvvmexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val score: String
)