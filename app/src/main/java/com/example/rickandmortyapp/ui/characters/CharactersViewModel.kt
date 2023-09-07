package com.example.rickandmortyapp.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortyapp.data.CharactersPagingSource
import com.example.rickandmortyapp.domain.use_case.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {
    val characters = Pager(PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            CharactersPagingSource(getCharactersUseCase)
        }).flow.cachedIn(viewModelScope)
}

