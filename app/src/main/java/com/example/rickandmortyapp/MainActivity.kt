package com.example.rickandmortyapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.ui.Screen
import com.example.rickandmortyapp.ui.character_details.views.CharacterDetailScreen
import com.example.rickandmortyapp.ui.characters.views.CharactersScreen
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharactersScreen.route
                    ) {
                        composable(route = Screen.CharactersScreen.route){
                            CharactersScreen(navController = navController,
                                hiltViewModel())
                        }
                        composable(route = Screen.CharacterDetailScreen.route+"/{characterId}"){
                            CharacterDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

