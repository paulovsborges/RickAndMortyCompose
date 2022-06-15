package com.example.rickandmortycompose.data.ktor

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val TIME_OUT = 60_000

private val ktorHttpClient = HttpClient(Android) {

//    Json serializer/deserializer
    install(JsonFeature) {

        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }
    }

//    Http logging
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger_Ktor =>", message)
            }
        }
        level = LogLevel.ALL
    }

//    HTTP response status observer
    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP_STATUS =>", "${response.status.value}")
        }
    }

//    Default headers for all requests
    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}