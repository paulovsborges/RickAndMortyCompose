package com.example.rickandmortycompose.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyWrapperResponse(
    @SerialName("info")
    val info: RickAndMortyInfoRes,
    @SerialName("results")
    val results: List<CharacterModel>
)

@Serializable
data class RickAndMortyInfoRes(
    @SerialName("count")
    val count: Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("prev")
    val prev: String?
)

@Serializable
data class CharacterModel(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

@Serializable
data class CharacterOrigin(
    val name: String,
    val url: String
)

@Serializable
data class CharacterLocation(
    val name: String,
    val url: String
)
