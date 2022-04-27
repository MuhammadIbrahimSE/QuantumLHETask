package com.example.nytimespopularapi.data.datasourceimpl

import com.example.nytimespopularapi.data.api.NewsService
import com.example.nytimespopularapi.data.datasource.NewsDataSource
import com.example.nytimespopularapi.model.MostPopularNewsApiResponse
import retrofit2.Response

class NewsDataSourceImpl(val apiService: NewsService) : NewsDataSource {
    override suspend fun getPopularNews(): Response<MostPopularNewsApiResponse> {
        return apiService.getMostPopularNews()
    }
}