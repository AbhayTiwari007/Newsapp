package com.example.tasknewsapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tasknewsapp.Models.Data
import com.example.tasknewsapp.R
import com.example.tasknewsapp.View.WebViewActvity

class Adapter(val items: Data, val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    class ViewHolder(itemView: View,context: Context) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val desc: TextView
        val img: ImageView


        init {
            // Define click listener for the ViewHolder's View.
            title = itemView.findViewById(R.id.titleTv)
            desc = itemView.findViewById(R.id.descreptionTv)

            img = itemView.findViewById(R.id.img)

img.setOnClickListener {
    val intent = Intent(context,WebViewActvity::class.java)
    intent.putExtra("key", "Kotlin")
   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent)
}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.itemhome, parent, false),context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(items.articles[position].title)
        holder.desc.setText(items.articles[position].description)
        Glide.with(context).
        load(items.articles[position].urlToImage).
        error(R.drawable.logo).
        into(holder.img);


    }

    override fun getItemCount(): Int {
        return items.articles.size
    }
}