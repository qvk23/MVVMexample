package com.example.mvvmexample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.data.Player
import kotlinx.android.synthetic.main.player_item.view.*

class PlayerAdapter(private val listPlayer: List<Player>) : RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindData(player: Player){
            itemView.textName.text = player.name
            itemView.textScore.text = player.score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false))
    }

    override fun getItemCount() = listPlayer.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.i("abc", "players adapter: $listPlayer")
        holder.bindData(listPlayer[position])
    }
}