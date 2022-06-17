package com.pvsb.rickandmortycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pvsb.rickandmortycompose.data.dto.PostResponse
import com.pvsb.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(), producer = {
                    value = viewModel.getPosts()
                }
            )

            RickAndMortyComposeTheme {
                LazyColumn() {
                    items(posts.value) {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 16.dp)) {
                            
                            Text(text = it.title, fontSize = 20.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = it.body, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}
