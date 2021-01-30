package com.example.condduit.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.entities.Article
import com.example.condduit.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed : LiveData<List<Article>>
        get() = _feed

    fun fetchGlobalFeed(){
        viewModelScope.launch {
            ArticlesRepo.getGlobalfeed().body()?.let {
                _feed.postValue(it.articles)
                Log.d("FEED" , "feed fetched ${it.articlesCount}")
            }

        }
    }
}