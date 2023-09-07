package com.example.rickandmortyapp.data.entity

import com.example.rickandmortyapp.domain.model.CharacterDetail
import com.example.rickandmortyapp.domain.model.Characters

data class CharactersDto(
    val info: Info,
    val results: List<Result>
)

fun CharactersDto.toCharacters(): Characters {
    val characters = results.map {
        CharacterDetail(
            gender = it.gender ?: "",
            id = it.id ?: 0,
            image = it.image ?: "",
            name = it.name ?: "",
            species = it.species ?: "",
            status = it.status ?: "",
            type = it.type ?: "",
            url = it.url ?: ""
        )
    }

    return Characters(
        nextPage = info.next,
        characters = characters
    )
}