package com.example.rickandmortyapp.ui.character_details

import com.example.rickandmortyapp.domain.model.CharacterDetail

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetail? = null,
    val error: String = ""
)