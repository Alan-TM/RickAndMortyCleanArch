package com.alan.rickandmortycleanarch.presentation.characters

import com.alan.rickandmortycleanarch.commons.StringUtils.EMPTY_STRING
import com.alan.rickandmortycleanarch.domain.model.Character

data class CharactersState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = EMPTY_STRING
)
