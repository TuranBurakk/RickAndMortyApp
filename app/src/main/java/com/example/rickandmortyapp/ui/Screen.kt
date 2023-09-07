package com.example.rickandmortyapp.ui

sealed class Screen(val route: String) {
    object CharactersScreen : Screen("characters_screen")
    object CharacterDetailScreen : Screen("character_detail_screen")
}