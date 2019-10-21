package com.example.mvvmexample.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.DiffUltiCallback
import com.example.mvvmexample.R
import kotlinx.android.synthetic.main.player_item.view.*

class ListPlayerAdapter: ListAdapter<Player, ListPlayerAdapter.MyViewHolder>(DiffUltiCallback()) {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindData(player: Player){
            itemView.textName.text = player.name
            itemView.textScore.text = player.score
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}