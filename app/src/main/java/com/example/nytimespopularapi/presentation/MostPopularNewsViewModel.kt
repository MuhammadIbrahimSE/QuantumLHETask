package com.example.nytimespopularapi.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimespopularapi.data.datasource.NewsDataSource
import com.example.nytimespopularapi.model.MostPopularNewsApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MostPopularNewsViewModel @Inject constructor(val dataSource: NewsDataSource) : ViewModel() {
    private val _newsList: MutableLiveData<MostPopularNewsApiResponse> = MutableLiveData()
    val newsList: LiveData<MostPopularNewsApiResponse>
        get() = _newsList

    private fun getMostPopularNews() {
        viewModelScope.launch(Dispatchers.IO) {
            //_getimagesResponse.postValue(Resource.Loading())

            try {
                val response = dataSource.getPopularNews()
                Log.e("response", "${response.body()!!.results!!.size}")
                _newsList.postValue(response.body())

            } catch (e: Exception) {
                //_getimagesResponse.postValue(Resource.Error(e.localizedMessage))
            }

        }
    }

    init {
        getMostPopularNews()
    }
}