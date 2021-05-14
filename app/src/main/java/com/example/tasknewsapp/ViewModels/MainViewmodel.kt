package com.example.tasknewsapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasknewsapp.Models.Data
import com.example.tasknewsapp.Repository.Repo

class MainViewmodel : ViewModel() {
    var data: MutableLiveData<Data>? = null
    fun getData(): LiveData<Data>? {
        data = Repo.getData()
        return data
    }
}