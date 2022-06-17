package com.pvsb.rickandmortycompose.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
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
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(),
        onClick = onClick,
        color = greyBackGroundColor,
        shape = MaterialTheme.shapes.small
    ) {

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            ImageLoader(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RectangleShape)
                    .height(250.dp), url = character.image
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = character.name,
                style = CustomTypography.typography.body1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(all = 8.dp)
            )

            if (isExpanded) {

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "${character.status} - ${character.species}",
                    style = CustomTypography.typography.body2,
                    modifier = Modifier.padding(all = 8.dp),
                    color = getCharacterStatusColor(character.status)
                )
            }
        }
    }
}

private fun getCharacterStatusColor(status: String): Color {

    return when (status) {
        "Alive" -> {
            greenColor
        }
        "Dead" -> {
            redColor
        }
        "Unknown" -> {
            greyColor
        }
        "unknown" ->{
            greyColor
        }
        else -> {
            Color.White
        }
    }
}