package com.pvsb.rickandmortycompose.di

import com.pvsb.rickandmortycompose.data.remote.PostService
import com.pvsb.rickandmortycompose.data.remote.PostServiceImpl
import com.pvsb.rickandmortycompose.data.remote.RickService
import com.pvsb.rickandmortycompose.data.remote.RickServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {

    @Binds
    fun postService(impl: PostServiceImpl): PostService

    @Binds
    fun rickANdMortyService(impl: RickServiceImpl): RickService
}