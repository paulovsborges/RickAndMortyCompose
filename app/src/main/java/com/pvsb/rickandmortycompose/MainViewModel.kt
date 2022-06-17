package com.pvsb.rickandmortycompose

import androidx.lifecycle.ViewModel
import com.pvsb.rickandmortycompose.data.dto.PostResponse
import com.pvsb.rickandmortycompose.data.remote.PostService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: PostService
) : ViewModel() {

    suspend fun getPosts(): List<PostResponse> {

        val list = mutableListOf<PostResponse>()

        val response = service.getPosts()

        list.addAll(response)

        return list
    }
}