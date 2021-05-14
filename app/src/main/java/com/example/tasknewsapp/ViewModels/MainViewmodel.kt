package com.example.tasknewsapp.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasknewsapp.Models.Data
import com.example.tasknewsapp.Repository.Repo

class MainViewmodel : ViewModel() {
    var data: MutableLiveData<Data>? = null
    fun getData(): LiveData<Data>? {
        Log.d("tag",data.toString()+" from viewmodel")
        if (data!=null){
            Log.d("tag",data.toString()+" from line ")
            return  data
        }
        data = Repo.getData()
        return data
    }
    init {
        Log.d("tag","created")
    }
}