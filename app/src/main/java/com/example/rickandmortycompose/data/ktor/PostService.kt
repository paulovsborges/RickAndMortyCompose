package com.example.rickandmortycompose.data.ktor

import com.example.rickandmortycompose.data.dto.PostRequest
import com.example.rickandmortycompose.data.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(req: PostRequest): PostResponse?
}