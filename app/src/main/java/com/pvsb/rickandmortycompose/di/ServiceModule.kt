package com.pvsb.rickandmortycompose.di

import com.pvsb.rickandmortycompose.data.remote.PostService
import com.pvsb.rickandmortycompose.data.remote.PostServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {

    @Binds
    fun postService(impl: PostServiceImpl): PostService

}