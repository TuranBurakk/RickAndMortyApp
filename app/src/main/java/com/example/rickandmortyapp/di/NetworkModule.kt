package com.example.rickandmortyapp.di

import com.example.rickandmortyapp.data.remote.ApiService
import com.example.rickandmortyapp.data.remote.Repository
import com.example.rickandmortyapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRickMortyApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRickMortyRepository(api: ApiService): Repository {
        return Repository(api)
    }
}