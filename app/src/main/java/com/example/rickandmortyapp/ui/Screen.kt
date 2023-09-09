package com.example.rickandmortyapp.ui

sealed class Screen(val route: String) {

    object SplashScreen : Screen("splash_screen")
    object CharactersScreen : Screen("characters_screen")
    object CharacterDetailScreen : Screen("character_detail_screen")
}