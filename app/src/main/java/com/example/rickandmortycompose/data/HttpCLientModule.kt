package com.example.rickandmortycompose.data

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val TIME_OUT = 60_000

val ktorHttpClient = HttpClient(Android) {

    engine {
        connectTimeout = TIME_OUT
        socketTimeout = TIME_OUT
    }

    JsonFeature.Config().apply {

        val json = kotlinx.serialization.json.Json {
            prettyPrint = true
            ignoreUnknownKeys= true
            isLenient = true
//            encodeDefaults = false
        }

        serializer = KotlinxSerializer(json)

    }

    Logging.Config().apply {
        level = LogLevel.ALL
    }


    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}