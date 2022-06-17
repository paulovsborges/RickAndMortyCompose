package com.pvsb.rickandmortycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.pvsb.rickandmortycompose.data.dto.CharactersResultsResponseDTO
import com.pvsb.rickandmortycompose.data.dto.PostResponse
import com.pvsb.rickandmortycompose.presentation.components.HomeScreen
import com.pvsb.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            viewModel.getCharacters()

            val content = mutableListOf<CharactersResultsResponseDTO>().toMutableStateList()

            viewModel.charactersList.observe(this) {
                content.addAll(it)
            }

            RickAndMortyComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(content)
                }
            }
        }
    }
}
