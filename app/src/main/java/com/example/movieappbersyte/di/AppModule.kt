package com.example.movieappbersyte.di

import com.example.movieappbersyte.api.ApiService
import com.example.movieappbersyte.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideBaseUrl()=Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(baseUrl:String):ApiService=
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}