package com.example.rickandmortycompose.data.ktor

import com.example.rickandmortycompose.data.model.UserEntity
import io.ktor.client.*
import io.ktor.client.request.*

class UserApi(private val client: HttpClient) {

    suspend fun getUserKtor(userId: String): UserEntity = client.get("")

}