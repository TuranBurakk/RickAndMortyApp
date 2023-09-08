package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.entity.toCharacterDetail
import com.example.rickandmortyapp.data.entity.toCharacters
import com.example.rickandmortyapp.domain.model.CharacterDetail
import com.example.rickandmortyapp.domain.model.Characters
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getCharacter(pageNumber: Int):Characters{
        val characters =  apiService.getCharacter(pageNumber)
        return  characters.toCharacters()
    }

    suspend fun getCharacterByID(characterId:Int): CharacterDetail{
        val characterDetail = apiService.getCharacterById(characterId)
        return characterDetail.toCharacterDetail()
    }
}