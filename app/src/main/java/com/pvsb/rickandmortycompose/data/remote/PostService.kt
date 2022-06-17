package com.pvsb.rickandmortycompose.data.remote

import com.pvsb.rickandmortycompose.data.dto.PostRequest
import com.pvsb.rickandmortycompose.data.dto.PostResponse

interface PostService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(req: PostRequest): PostResponse?
}