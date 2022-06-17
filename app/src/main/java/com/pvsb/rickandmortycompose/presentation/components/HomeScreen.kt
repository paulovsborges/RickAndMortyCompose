package com.pvsb.rickandmortycompose.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.pvsb.rickandmortycompose.data.dto.CharactersResultsResponseDTO

@Composable
fun HomeScreen(content: List<CharactersResultsResponseDTO>) {

    LazyColumn() {
        items(content) {
            CharacterCard(imageUrl = it.image, name = it.name)
        }
    }
}