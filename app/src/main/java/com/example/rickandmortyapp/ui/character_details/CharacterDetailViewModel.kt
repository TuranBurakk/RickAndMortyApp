package com.example.rickandmortyapp.ui.character_details

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.use_case.GetCharacterDetailUseCase
import com.example.rickandmortyapp.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    savedStateHandle : SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHARACTER_ID)?.let { characterId ->
            getCharacter(characterId)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getCharacter(characterId: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            try {
                val result = getCharacterDetailUseCase.getCharacterDetail(characterId.toInt())
                _state.value = state.value.copy(character = result)
            } catch (e: HttpException) {
                _state.value = state.value.copy(error = e.message.toString())
            } catch (e: Exception) {
                _state.value = state.value.copy(error = e.message ?: "Unknown error!")
            } finally {
                _state.value = state.value.copy(isLoading = false)
            }

        }

    }
}