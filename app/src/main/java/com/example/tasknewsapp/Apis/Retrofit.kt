package com.example.tasknewsapp.Apis
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object Retrofit {
    const val MainServer = "https://newsapi.org"


    val retrofitClient: Retrofit.Builder by lazy {



        val logging = HttpLoggingInterceptor()


        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: Api by lazy {
        retrofitClient
            .build()
            .create(Api::class.java)
    }
}