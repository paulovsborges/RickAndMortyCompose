package com.pvsb.rickandmortycompose.data.remote

import com.pvsb.rickandmortycompose.data.dto.CharactersResponseDTO

interface RickService {

    suspend fun getCharacters() : CharactersResponseDTO
}