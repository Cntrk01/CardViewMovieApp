package com.example.movieappbersyte.api

import com.example.movieappbersyte.helper.Constants
import com.example.movieappbersyte.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTvShows():Response<TvShowResponse>


}