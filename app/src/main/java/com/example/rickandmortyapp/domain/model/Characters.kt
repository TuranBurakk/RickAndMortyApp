package com.example.rickandmortyapp.domain.model

data class Characters(
    val nextPage: String?,
    val characters: List<CharacterDetail>
)
