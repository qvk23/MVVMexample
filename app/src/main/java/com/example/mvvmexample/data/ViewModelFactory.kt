package com.example.mvvmexample.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repositoryImp: RepositoryImp) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repositoryImp) as T
    }
}