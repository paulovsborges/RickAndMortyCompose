package com.pvsb.rickandmortycompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvsb.rickandmortycompose.data.dto.PostResponse
import com.pvsb.rickandmortycompose.data.remote.PostService
import com.pvsb.rickandmortycompose.data.remote.RickService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: PostService,
    private val rickService: RickService
) : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                getCharacters()
            }catch (e: Exception){
                println(e.message)
            }
        }
    }

    suspend fun getPosts(): List<PostResponse> {

        val list = mutableListOf<PostResponse>()

        val response = service.getPosts()

        list.addAll(response)

        return list
    }

    suspend fun getCharacters(){

        val response = rickService.getCharacters()

        println(response)
    }
}