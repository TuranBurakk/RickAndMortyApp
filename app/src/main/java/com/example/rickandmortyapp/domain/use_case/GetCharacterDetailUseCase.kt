package com.example.rickandmortyapp.domain.use_case

import com.example.rickandmortyapp.data.remote.Repository
import com.example.rickandmortyapp.domain.model.CharacterDetail
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun getCharacterDetail(characterId:Int):CharacterDetail{
       return repository.getCharacterByID(characterId)
    }
}