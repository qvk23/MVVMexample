package com.example.mvvmexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmexample.data.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val database by lazy {
        AppDatabase.getInstance(this)
    }
    private val repository by lazy {
        RepositoryImp(database.playerDao())
    }
    private val viewModelFactory by lazy {
        ViewModelFactory(repository)
    }
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ListPlayerAdapter()
        recyclerViewPlayer.adapter = adapter
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        button.setOnClickListener {
            val player = Player(0, textName.text.toString(), textScore.text.toString())
            viewModel.addPlayer(player)

        }
        viewModel.item.observe(this, Observer { players ->
            adapter.submitList(players)
        })
    }
}
