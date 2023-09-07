package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.entity.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacter(@Query("page") pageNumber: Int): CharactersDto


}