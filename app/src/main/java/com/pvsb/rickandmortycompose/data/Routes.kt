package com.pvsb.rickandmortycompose.data

import com.pvsb.rickandmortycompose.BuildConfig

object Routes {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val POSTS = "$BASE_URL/posts"

    const val CHARACTERS = "${BuildConfig.BASE_URL}/character"

}