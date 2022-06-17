package com.pvsb.rickandmortycompose.data.remote

import com.pvsb.rickandmortycompose.data.Routes.POSTS
import com.pvsb.rickandmortycompose.data.dto.PostRequest
import com.pvsb.rickandmortycompose.data.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

class PostServiceImpl @Inject constructor(
    private val client: HttpClient
) : PostService {

    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get {
                url(POSTS)
            }
        } catch (e: RedirectResponseException) {
//        code 3xx
            emptyList<PostResponse>()
        } catch (e: ClientRequestException) {
//            status 4xx
            emptyList<PostResponse>()
        } catch (e: ServerResponseException) {
//            status 5xx
            emptyList<PostResponse>()
        }
    }

    override suspend fun createPost(req: PostRequest): PostResponse? {
        return try {
            client.post<PostResponse>() {
                url(POSTS)
                contentType(ContentType.Application.Json)
                body = req
            }
        } catch (e: RedirectResponseException) {
//        code 3xx
            null
        } catch (e: ClientRequestException) {
//            status 4xx
            null
        } catch (e: ServerResponseException) {
//            status 5xx
            null
        }
    }
}