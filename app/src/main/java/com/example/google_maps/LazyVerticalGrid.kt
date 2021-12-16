package com.example.google_maps


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.google_maps.ui.theme.Google_MapsTheme
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class LazyVerticalGrid : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting2(onClick = {
            })
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Greeting2(onClick:() -> Unit) {
    val data = listOf("☕️", "🙂", "🥛", "🎉", "📐", "🎯", "🧩", "😄", "🥑")

    val context = LocalContext.current

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp)
    ) {
        repeat(100){
            items(data) { item ->

                Card(
                    modifier = Modifier.padding(4.dp),
                    backgroundColor = Color(
                        red = Random.nextInt(0,255),
                        blue = Random.nextInt(0,255),
                        green = Random.nextInt(0,255)
                    )
                ) {

                    Button(onClick = onClick) {
                        Text(
                            text = item,
                            fontSize = 42.sp,
                            modifier = Modifier
                                .padding(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    Google_MapsTheme {
        Greeting2(onClick = {

        })
    }
}