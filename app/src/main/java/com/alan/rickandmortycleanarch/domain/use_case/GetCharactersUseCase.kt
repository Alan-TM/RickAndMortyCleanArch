package com.alan.rickandmortycleanarch.domain.use_case

import com.alan.rickandmortycleanarch.commons.Resource
import com.alan.rickandmortycleanarch.domain.model.Character
import com.alan.rickandmortycleanarch.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCharactersUseCase(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loading())
        emit(repository.getCharacters())
    }
}
