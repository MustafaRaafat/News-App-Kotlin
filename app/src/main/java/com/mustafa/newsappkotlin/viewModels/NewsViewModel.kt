package com.mustafa.newsappkotlin.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mustafa.newsappkotlin.models.HeadLinesModel
import com.mustafa.newsappkotlin.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val TAG = "news view Model: "

    val headLines: MutableLiveData<HeadLinesModel> by lazy {
        MutableLiveData<HeadLinesModel>().also {
            loadHeadlines()
        }
    }


    private fun loadHeadlines() {

        GlobalScope.launch(Dispatchers.IO) {
            val response = repository.getHeadLines()
            if (response.isSuccessful) {
                headLines.postValue(response.body())
            }
        }
    }

}