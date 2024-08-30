package com.example.newsnow.models

import com.example.newsnow.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)