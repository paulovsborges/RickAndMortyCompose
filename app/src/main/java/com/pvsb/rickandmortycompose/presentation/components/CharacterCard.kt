package com.pvsb.rickandmortycompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pvsb.rickandmortycompose.presentation.ImageLoader

@Composable
fun CharacterCard(
    imageUrl: String,
    name: String,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        ImageLoader(url = imageUrl)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = name)
    }
}