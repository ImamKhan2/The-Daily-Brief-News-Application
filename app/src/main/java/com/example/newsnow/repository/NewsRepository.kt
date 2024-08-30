package com.example.newsnow.repository

import androidx.room.Query
import com.example.newsnow.api.RetrofitInstance
import com.example.newsnow.database.ArticleDatabase
import com.example.newsnow.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository(val database: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = database.getArticleDao().upsert(article)

     fun getFavouriteNews() = database.getArticleDao().getAllArticles()

    suspend fun deleteArticles(article: Article) = database.getArticleDao().deleteArticle(article)
}