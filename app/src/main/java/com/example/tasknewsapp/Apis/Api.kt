package com.example.tasknewsapp.Apis

import com.example.tasknewsapp.Models.Data
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/v2/everything?q=tesla&from=2021-04-14&sortBy=publishedAt&apiKey=acb75f172519431fa334e3b35404fef9")
    fun getData() : Call<Data>
}