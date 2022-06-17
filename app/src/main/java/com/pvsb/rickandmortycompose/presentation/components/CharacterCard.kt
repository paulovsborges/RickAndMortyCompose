package com.pvsb.rickandmortycompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pvsb.rickandmortycompose.data.dto.CharactersResultsResponseDTO

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CharacterCard(
    character: CharactersResultsResponseDTO,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isExpanded: Boolean
) {

    Surface(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            ImageLoader(url = character.image)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = character.name)

            if (isExpanded) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = character.status)
            }
        }
    }
}