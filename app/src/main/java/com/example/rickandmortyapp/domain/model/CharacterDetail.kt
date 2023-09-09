package com.example.rickandmortyapp.domain.model

data class CharacterDetail(
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    val location : String,
    val origin : String
)
