package com.pvsb.rickandmortycompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation

@Composable
fun ImageLoader(url: String, modifier: Modifier = Modifier) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = url)
            .apply {
                kotlin.run {
                    crossfade(500)
                    transformations(RoundedCornersTransformation())
                }
            }.build()
    )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}