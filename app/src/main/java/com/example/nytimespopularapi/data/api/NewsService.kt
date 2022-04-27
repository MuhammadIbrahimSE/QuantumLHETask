package com.example.nytimespopularapi.data.api

import com.example.nytimespopularapi.model.MostPopularNewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json")
    suspend fun getMostPopularNews(): Response<MostPopularNewsApiResponse>
}