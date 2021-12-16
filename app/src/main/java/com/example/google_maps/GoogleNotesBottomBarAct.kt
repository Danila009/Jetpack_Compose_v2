package com.example.google_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.google_maps.ui.theme.Google_MapsTheme
import kotlin.math.roundToInt

class GoogleNotesBottomBarAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Google_MapsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GoogleNotesBottomBarFun()
                }
            }
        }
    }
}

@Preview
@Composable
fun GoogleNotesBottomBarFun() {
    val listNav = listOf("Home","Search")
    val navCon = rememberNavController()

    val bottomBarHeight = 85.dp
    val bottomBarHeightPx = with(LocalDensity.current) {
        bottomBarHeight.roundToPx().toFloat()
    }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }
    val nestedScrollConnectionPx = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = bottomBarOffsetHeightPx.value + delta
                bottomBarOffsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }
    val scaffoldState = rememberScaffoldState()

    Scaffold(modifier = Modifier.nestedScroll(nestedScrollConnectionPx),scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = { Text(text = "TopAppBar",textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())}, modifier = Modifier
                .offset {
                IntOffset(x = 0, y = bottomBarOffsetHeightPx.value.roundToInt())
            })
        },bottomBar = {

            BottomAppBar(cutoutShape = RoundedCornerShape(50), modifier = Modifier
                .offset {
                IntOffset(x = 0, y = -bottomBarOffsetHeightPx.value.roundToInt())
            }) {

                BottomNavigation(modifier = Modifier
                    .offset {
                        IntOffset(x = 0, y = -bottomBarOffsetHeightPx.value.roundToInt())
                    }) {
                    listNav.forEach{
                        BottomNavigationItem(selected = true, onClick = {
                            navCon.navigate(it)
                        },label = {
                            Text(text = it)
                        },icon = {
                            when(it){
                                "Home"-> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                                "Search"-> Icon(imageVector = Icons.Default.Search, contentDescription = null)
                            }
                        })
                    }
                }
            }

        },floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    navCon.navigate("Profile")
                },
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(),
                modifier = Modifier
                    .offset {
                        IntOffset(x = 0, y = -bottomBarOffsetHeightPx.value.roundToInt())
                    }
            ) {
                Icon(
                    Icons.Filled.Add, null
                )
            }

        },floatingActionButtonPosition = FabPosition.Center, isFloatingActionButtonDocked = true,content = { innerPadding ->
            NavHost(navController = navCon, startDestination = "Home"){
                composable("Home"){
                    LazyColumn(content = {
                        items(200){
                            Card(
                                shape = RoundedCornerShape(20.dp),
                                elevation = 2.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                            ) {
                                Column {
                                    Spacer(modifier = Modifier
                                        .height(10.dp)
                                        .fillMaxWidth())

                                    Text(text = "Text $it",textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())

                                    Spacer(modifier = Modifier
                                        .height(10.dp)
                                        .fillMaxWidth())
                                }
                            }
                        }
                    },contentPadding = innerPadding)
                }
                composable("Search"){

                }
                composable("Profile"){

                }
            }
        }
    )
}
