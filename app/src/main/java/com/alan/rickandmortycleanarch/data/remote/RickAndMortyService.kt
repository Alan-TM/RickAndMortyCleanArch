package com.alan.rickandmortycleanarch.data.remote

import com.alan.rickandmortycleanarch.data.remote.dto.CharacterDto
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("/api/character")
    suspend fun getCharacter(): CharacterDto
}