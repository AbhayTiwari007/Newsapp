package com.example.tasknewsapp.View

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasknewsapp.Adapters.Adapter
import com.example.tasknewsapp.R
import com.example.tasknewsapp.Utils.ChromeCustomTabs
import com.example.tasknewsapp.ViewModels.MainViewmodel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewmodel
    lateinit var rv: RecyclerView
    lateinit var adapter: Adapter
    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.homeRv)
        progress = findViewById(R.id.progress);


        setTitle("News App")
        rv.layoutManager = LinearLayoutManager(applicationContext)
        viewModel = ViewModelProvider(this).get(MainViewmodel::class.java)
        viewModel.getData()?.observe(this, Observer {
//            Log.d("taggy", "get response${it}")
            adapter = Adapter(it, applicationContext)
            rv.adapter = adapter
            progress.isVisible = false
        })

    }

}