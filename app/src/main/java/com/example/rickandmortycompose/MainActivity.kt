package com.example.rickandmortycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import com.example.rickandmortycompose.data.ktor.MortyApi
import com.example.rickandmortycompose.data.model.CharacterModel
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme

class MainActivity : ComponentActivity() {

    private val client = MortyApi.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val data = produceState<List<CharacterModel>>(
                initialValue = emptyList(),
                producer = {
                    value =
                }
            )

            RickAndMortyComposeTheme {
                LazyColumn() {
                    items(data.value) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(text = it.name)
                        }
                    }
                }
            }
        }
    }
}
