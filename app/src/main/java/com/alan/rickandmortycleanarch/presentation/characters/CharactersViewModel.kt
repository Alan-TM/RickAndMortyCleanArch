package com.alan.rickandmortycleanarch.presentation.characters

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alan.rickandmortycleanarch.commons.Resource
import com.alan.rickandmortycleanarch.commons.StringUtils.EMPTY_STRING
import com.alan.rickandmortycleanarch.domain.use_case.GetCharactersUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    init {
        getCharacters()
    }

    private fun getCharacters() {
        getCharactersUseCase().onEach { result ->
            Log.e("results", result.data.toString())
            when (result) {
                is Resource.Success -> {
                    _state.value = result.data?.let { CharactersState(characters = it) }!!
                }
                is Resource.Error -> {
                    _state.value = CharactersState(error = result.message ?: EMPTY_STRING)
                }
                is Resource.Loading -> {
                    _state.value = CharactersState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
