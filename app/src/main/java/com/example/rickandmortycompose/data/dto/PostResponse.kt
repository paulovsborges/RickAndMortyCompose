package com.example.rickandmortycompose.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

@Serializable
data class PostRequest(
    val userId: Int,
    val title: String,
    val body: String
)
