package com.alan.rickandmortycleanarch.domain.repository

import com.alan.rickandmortycleanarch.commons.Resource
import com.alan.rickandmortycleanarch.domain.model.Character

interface RickAndMortyRepository {
    suspend fun getCharacters(): Resource<List<Character>>
}
