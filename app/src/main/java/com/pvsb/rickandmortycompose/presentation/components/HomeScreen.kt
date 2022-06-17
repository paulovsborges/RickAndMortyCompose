package com.pvsb.rickandmortycompose.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import com.pvsb.rickandmortycompose.data.dto.CharactersResultsResponseDTO

@Composable
fun HomeScreen(content: List<CharactersResultsResponseDTO>) {

    var isExpanded by remember { mutableStateOf<CharactersResultsResponseDTO?>(null) }

    LazyColumn() {
        items(content) {
            CharacterCard(it, onClick = {
                isExpanded = if (isExpanded == it) null else it
            }, isExpanded = isExpanded == it)
        }
    }
}