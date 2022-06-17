package com.pvsb.rickandmortycompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvsb.rickandmortycompose.data.dto.CharactersResultsResponseDTO
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

    private val _charactersList = MutableLiveData<List<CharactersResultsResponseDTO>>()
    val charactersList: LiveData<List<CharactersResultsResponseDTO>> = _charactersList

    suspend fun getPosts(): List<PostResponse> {

        val list = mutableListOf<PostResponse>()

        val response = service.getPosts()

        list.addAll(response)

        return list
    }

    fun getCharacters() {

        viewModelScope.launch {

            val response = rickService.getCharacters()
            _charactersList.value = response.results
        }
    }
}