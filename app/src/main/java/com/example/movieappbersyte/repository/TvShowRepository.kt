package com.example.movieappbersyte.repository

import com.example.movieappbersyte.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject
 constructor(private val apiService:ApiService){
     suspend fun getTvShows()=apiService.getTvShows()
}