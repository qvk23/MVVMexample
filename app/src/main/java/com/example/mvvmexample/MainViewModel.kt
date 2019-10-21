package com.example.mvvmexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.data.Player
import com.example.mvvmexample.data.RepositoryImp
import kotlinx.coroutines.launch

class MainViewModel(private val repositoryImp: RepositoryImp): ViewModel() {
    val item = MutableLiveData<List<Player>>()
    private var list = mutableListOf<Player>()
//    val item: LiveData<List<Player>>
//        get() = _item

    init {
        getPlayers()
    }
    private fun getPlayers() =
        viewModelScope.launch {
//            list = repositoryImp.getPlayers() as MutableList<Player>
            item.postValue(repositoryImp.getPlayers())
        }
    fun addPlayer(player: Player) =
        viewModelScope.launch {
            repositoryImp.addPlayer(player)
            list.add(player)
            item.postValue(list)
//            players.postValue(repositoryImp.getPlayers())
        }
}