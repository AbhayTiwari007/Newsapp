package com.example.tasknewsapp.Models

data class Data(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)