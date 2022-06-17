package com.example.rickandmortycompose.di

import com.example.rickandmortycompose.data.ktor.PostService
import com.example.rickandmortycompose.data.ktor.PostServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {

    @Binds
    fun postService(impl: PostServiceImpl): PostService

}