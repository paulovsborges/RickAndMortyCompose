package com.example.rickandmortycompose.data.ktor

import com.example.rickandmortycompose.util.ResponseState
import io.ktor.client.*
import io.ktor.client.request.*

class MortyApiImpl(
    private val client: HttpClient
) : MortyApi {

    override suspend fun getCharacters(): ResponseState {

        val clientKtor = HttpClient()

        return clientKtor.request {
            url("")

        }
    }
}