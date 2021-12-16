package com.example.google_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.google_maps.ui.theme.Google_MapsTheme
import kotlinx.coroutines.launch

class NavigationDrawer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Google_MapsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting3()
                }
            }
        }
    }
}

@Composable
fun Greeting3() {

    //val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        drawerContent = {
            Column {
                Image(painter = painterResource(id = R.drawable.p5), contentDescription = null)
                Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize()) {
                    Button(onClick = {
                        scope.launch { scaffoldState.drawerState.close() }
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Назад ->")
                    }
                }
            }
        }, scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = { Text(text = "NavigationDrawer")}, navigationIcon = {
                IconButton(onClick = {
                    scope.launch { scaffoldState.drawerState.open() }
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_drag), contentDescription = null)
                }
            })
        }
    ) {
        Image(painter = painterResource(id = R.drawable.p8), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    Google_MapsTheme {
        Greeting3()
    }
}