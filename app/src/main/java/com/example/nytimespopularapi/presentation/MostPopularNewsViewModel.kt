package com.example.nytimespopularapi.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimespopularapi.data.datasource.NewsDataSource
import com.example.nytimespopularapi.model.MostPopularNewsApiResponse
import com.example.nytimespopularapi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MostPopularNewsViewModel @Inject constructor(val dataSource: NewsDataSource) : ViewModel() {
    private val _newsList: MutableLiveData<Resource<List<MostPopularNewsApiResponse.Result?>>> =
        MutableLiveData()
    val newsList: LiveData<Resource<List<MostPopularNewsApiResponse.Result?>>>
        get() = _newsList

    private fun getMostPopularNews() {
        viewModelScope.launch(Dispatchers.IO) {
            _newsList.postValue(Resource.Loading())
            try {
                val response = dataSource.getPopularNews()
                if (response.isSuccessful) {
                    response.body()?.let { result ->
                        _newsList.postValue(Resource.Success(result.results))
                    }
                } else {
                    _newsList.postValue(Resource.Error(response.message()))
                }

            } catch (e: Exception) {
                //or we can use coroutines exception handler
                _newsList.postValue(Resource.Error(e.localizedMessage))
            }

        }
    }

    init {
        getMostPopularNews()
    }
}