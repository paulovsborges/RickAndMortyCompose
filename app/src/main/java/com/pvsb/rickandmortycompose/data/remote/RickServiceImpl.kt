package com.pvsb.rickandmortycompose.data.remote

import com.pvsb.rickandmortycompose.data.Routes.CHARACTERS
import com.pvsb.rickandmortycompose.data.dto.CharactersResponseDTO
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class RickServiceImpl @Inject constructor(
    private val client: HttpClient
): RickService {

    override suspend fun getCharacters(): CharactersResponseDTO {
        return client.get{
            url(CHARACTERS)
        }
    }
}