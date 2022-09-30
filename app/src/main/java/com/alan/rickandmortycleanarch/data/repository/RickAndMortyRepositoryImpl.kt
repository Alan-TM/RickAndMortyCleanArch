package com.alan.rickandmortycleanarch.data.repository

import com.alan.rickandmortycleanarch.commons.Resource
import com.alan.rickandmortycleanarch.commons.StringUtils.EMPTY_STRING
import com.alan.rickandmortycleanarch.data.remote.RickAndMortyService
import com.alan.rickandmortycleanarch.data.remote.dto.toCharacters
import com.alan.rickandmortycleanarch.domain.model.Character
import com.alan.rickandmortycleanarch.domain.repository.RickAndMortyRepository
import retrofit2.HttpException
import java.io.IOException

class RickAndMortyRepositoryImpl(
    private val service: RickAndMortyService
) : RickAndMortyRepository {
    override suspend fun getCharacters(): Resource<List<Character>> {
        return try {
            Resource.Success(data = service.getCharacter().toCharacters())
        } catch (e: HttpException) {
            Resource.Error(message = e.localizedMessage ?: EMPTY_STRING)
        } catch (e: IOException) {
            Resource.Error(message = e.localizedMessage ?: EMPTY_STRING)
        }
    }
}
