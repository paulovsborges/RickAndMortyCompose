package com.pvsb.rickandmortycompose.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponseDTO(
    val info: CharactersInfoResponseDTO,
    val results : List<CharactersResultsResponseDTO>
)

@Serializable
data class CharactersInfoResponseDTO(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)

@Serializable
data class CharactersResultsResponseDTO(
    val id: Int,
    val name: String,
    val status: String,
    val image: String
)


