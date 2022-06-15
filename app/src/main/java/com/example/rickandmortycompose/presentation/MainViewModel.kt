package com.example.rickandmortycompose.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val ktorClient: HttpClient
) : ViewModel() {

}