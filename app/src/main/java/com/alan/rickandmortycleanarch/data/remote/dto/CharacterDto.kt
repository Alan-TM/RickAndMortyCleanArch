package com.alan.rickandmortycleanarch.data.remote.dto

import com.alan.rickandmortycleanarch.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)

fun CharacterDto.toCharacters(): List<Character> {
    return results.map { character ->
        Character(
            name = character.name,
            image = character.image,
            gender = character.gender
        )
    }
}
