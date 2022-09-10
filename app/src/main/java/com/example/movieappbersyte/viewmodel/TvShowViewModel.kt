package com.example.movieappbersyte.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappbersyte.models.TvShowItem
import com.example.movieappbersyte.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject constructor(private val repo: TvShowRepository) : ViewModel() {
    private val _response = MutableLiveData<List<TvShowItem>>()
    val _responseTvShow: LiveData<List<TvShowItem>>
        get() = _response

//    private val _pagePoint = MutableLiveData<List<TvShowItem>>()
//    val _pagePoints: LiveData<List<TvShowItem>>
//        get() = _pagePoint

    init {
        getAllTvShows()

    }

    private fun getAllTvShows() = viewModelScope.launch {
        repo.getTvShows().let {
            if (it.isSuccessful) {
                _response.postValue(it.body())
            } else {
                Log.d("AllTv", "gettAllTvShows Error:${it.code()}")
            }
        }
    }

//    private fun getPagePoint() = viewModelScope.launch {
//        repo.getPagePoint().let {
//            if(it.isSuccessful){
//                _pagePoint.postValue(it.body())
//            }else {
//                Log.d("pagePoint", "pagePoint Error:${it.code()}")
//            }
//        }
//    }
}