package com.example.mvvmexample

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvmexample.data.Player

class DiffUltiCallback: DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}