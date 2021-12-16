package com.example.google_maps

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.google_maps.ui.theme.Google_MapsTheme


data class ListItems(val name:String)

@ExperimentalFoundationApi
class ListItemAct : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Google_MapsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DisplayList(list = listItems)
                }
            }
        }
    }
}

@Composable
fun ListItem(item:ListItems) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(59.dp)
            .background(Color.Gray)
    ) {
        Row(modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "user icon",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(CenterVertically)
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(CenterVertically),
                text = item.name,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}
private val listItems: List<ListItems> = listOf(
    ListItems("Jayme"),
    ListItems("Gil"),
    ListItems("Juice WRLD"),
    ListItems("Callan"),
    ListItems("Braxton"),
    ListItems("Kyla"),
    ListItems("Lil Mosey"),
    ListItems("Allan"),
    ListItems("Mike"),
    ListItems("Drew"),
    ListItems("Nia"),
    ListItems("Coi Relay")
)

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@Composable
fun DisplayList(list: List<ListItems>) {

    LazyColumn(modifier = Modifier.fillMaxWidth(1f)){
        val grouped = list.groupBy { it.name[0] }

        grouped.forEach { initial, items ->
            stickyHeader {
                Text(
                    text = initial.toString(),
                    modifier = Modifier.padding(10.dp)
                )
            }
            items(items) { item ->
                ListItem(item = item)
            }
        }

    }
}

@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Google_MapsTheme {
        DisplayList(list = listItems)
    }
}