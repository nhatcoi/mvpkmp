package com.nhatdev.newskmp.data.repository

import com.nhatdev.newskmp.data.database.NewsDao
import com.nhatdev.newskmp.data.model.Article
import kotlinx.coroutines.IO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class LocalNewsRepository(
    private val newsDao: NewsDao
) {
    suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    suspend fun deleteAllBookmark() {
        newsDao.deleteAllBookmark()
    }

    fun getArticles() = newsDao.getArticles().flowOn(Dispatchers.IO)

    suspend fun getArticle(articleId: String): Article? {
        return newsDao.getArticle(articleId = articleId)
    }
}