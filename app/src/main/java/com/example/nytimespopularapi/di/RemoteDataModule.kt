package com.example.nytimespopularapi.di

import com.example.nytimespopularapi.data.api.NewsService
import com.example.nytimespopularapi.data.datasource.NewsDataSource
import com.example.nytimespopularapi.data.datasourceimpl.NewsDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    //provides remote data source
    @Provides
    fun provideNewsRemoteDataSource(apiService: NewsService): NewsDataSource =
        NewsDataSourceImpl(apiService)
}