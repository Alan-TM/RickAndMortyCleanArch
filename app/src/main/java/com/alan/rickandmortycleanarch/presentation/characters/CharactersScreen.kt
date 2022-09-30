package com.alan.rickandmortycleanarch.presentation.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alan.rickandmortycleanarch.presentation.characters.components.CharacterListItem
import org.koin.androidx.compose.getViewModel

@Composable
fun CharactersScreen(
    charactersViewModel: CharactersViewModel = getViewModel()
) {
    val state = charactersViewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.characters) { character ->
                CharacterListItem(character = character)
            }
        }
    }

    if (state.error.isNotBlank()) {
        Text(text = state.error)
    }
}
