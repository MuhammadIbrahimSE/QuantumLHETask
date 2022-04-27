package com.example.nytimespopularapi.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimespopularapi.R
import com.example.nytimespopularapi.data.datasource.NewsDataSource
import com.example.nytimespopularapi.model.MostPopularNewsApiResponse
import com.example.nytimespopularapi.utils.Resource
import com.example.nytimespopularapi.utils.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MostPopularNewsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    val dataSource: NewsDataSource
) : ViewModel() {
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
        if (context.isInternetAvailable()) {
            getMostPopularNews()
        } else {
            _newsList.postValue(Resource.Error(context.getString(R.string.no_network_available)))
        }
    }
}