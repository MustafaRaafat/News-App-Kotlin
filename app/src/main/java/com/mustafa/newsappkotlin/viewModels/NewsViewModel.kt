package com.mustafa.newsappkotlin.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mustafa.newsappkotlin.models.HeadLinesModel
import com.mustafa.newsappkotlin.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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


    private fun loadHeadlines(){

        repository.getHeadLines().enqueue(object : Callback<HeadLinesModel>{
            override fun onFailure(call: Call<HeadLinesModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<HeadLinesModel>,
                response: Response<HeadLinesModel>
            ) {
                headLines.value=response.body()
            }
        })
    }

}