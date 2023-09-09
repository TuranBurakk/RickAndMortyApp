package com.example.rickandmortyapp.data.entity

import com.example.rickandmortyapp.domain.model.CharacterDetail

data class Result(
    val created: String?,
    val episode: List<String?>?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val location: Location?,
    val name: String?,
    val origin: Origin?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
)

fun Result.toCharacterDetail(): CharacterDetail {
    return CharacterDetail(
        gender = gender ?: "",
        id = id ?: 0,
        image = image ?: "",
        name = name ?: "",
        species = species ?: "",
        status = status ?: "",
        type = type ?: "",
        url = url ?: "",
        location = location?.name ?: "",
        origin = origin?.name ?: ""
    )
}