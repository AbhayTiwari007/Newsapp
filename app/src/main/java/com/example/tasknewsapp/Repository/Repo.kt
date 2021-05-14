package com.example.tasknewsapp.Repository

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tasknewsapp.Apis.Retrofit
import com.example.tasknewsapp.Models.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repo {
    val serviceData = MutableLiveData<Data>()

    fun getData(): MutableLiveData<Data> {
        Log.d("tag", " from repo call")
        val call = Retrofit.apiInterface.getData()
        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val data = response.body()

                serviceData.value = data
//               Log.d("tagy", serviceData.toString())
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                serviceData.value = null

            }

        })
        return serviceData
    }
}


