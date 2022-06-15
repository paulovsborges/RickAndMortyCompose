package com.example.rickandmortycompose.data.ktor

import com.example.rickandmortycompose.data.ktorHttpClient
import com.example.rickandmortycompose.util.ResponseState

interface MortyApi {

    suspend fun getCharacters(): ResponseState

    companion object {
        fun create(): MortyApi{
            return MortyApiImpl(
                client = ktorHttpClient
            )
        }
    }
}