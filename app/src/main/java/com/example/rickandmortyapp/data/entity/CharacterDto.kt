package com.example.rickandmortyapp.data.entity

import com.example.rickandmortyapp.domain.model.CharacterDetail

data class CharacterDto(
    val created: String,
    val episode: List<Any>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationX,
    val name: String,
    val origin: OriginX,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDto.toCharacterDetail(): CharacterDetail {
    return CharacterDetail(
        gender = gender,
        id = id,
        image = image,
        name = name,
        species = species,
        status = status,
        type = type,
        url = url
    )
}