package com.example.nytimespopularapi.data.datasource

import com.example.nytimespopularapi.model.MostPopularNewsApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsDataSource {
    suspend fun getPopularNews(): Response<MostPopularNewsApiResponse>
}