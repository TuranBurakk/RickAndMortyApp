package com.example.rickandmortyapp.ui.characters.views


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.rickandmortyapp.ui.characters.CharactersViewModel


@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val characters = viewModel.characters.collectAsLazyPagingItems()


    Box(modifier = Modifier.fillMaxSize()) {
        if (characters.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(
                    count = characters.itemCount,
                    key = characters.itemKey { it.id },
                ) { index ->
                    val character = characters[index]
                    if (character != null) {
                        CharacterRow(
                            character,
                        )
                    }
                }
                item {
                    if (characters.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}
