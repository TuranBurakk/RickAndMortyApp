package com.example.rickandmortyapp.domain.use_case

import com.example.rickandmortyapp.data.remote.Repository
import com.example.rickandmortyapp.domain.model.Characters
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend  fun executeGetCharacters(pageNumber:Int): Characters  {
       return repository.getCharacter(pageNumber)
    }
}