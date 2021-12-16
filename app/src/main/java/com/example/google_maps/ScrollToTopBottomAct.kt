package com.example.google_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import androidx.navigation.compose.rememberNavController
import com.example.google_maps.ui.theme.Google_MapsTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class ScrollToTopBottomAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Google_MapsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ScrollToTopBottom()
                }
            }
        }
    }
}

@Preview
@Composable
fun ScrollToTopBottom() {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

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

    val isTopButtonVisible = remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "ScrollToTopBottom", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            }, modifier = Modifier
                .offset {

                    if (isTopButtonVisible.value) {
                        IntOffset(x = 0, y = bottomBarOffsetHeightPx.value.roundToInt())
                    } else {
                        IntOffset(x = 0, y = 0)
                    }

                })
        },content = { innerPadding ->

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .background(Color.White)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ){
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
            }

            Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxSize()) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            listState.animateScrollToItem(0)
                        }
                    },
                    shape = RoundedCornerShape(50),
                    backgroundColor = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(16.dp)
                        .offset {
                            if (isTopButtonVisible.value) {
                                IntOffset(x = 0, y = -bottomBarOffsetHeightPx.value.roundToInt())
                            } else {
                                IntOffset(x = 0, y = 500)
                            }
                        }
                ) {
                    Icon(Icons.Filled.KeyboardArrowUp, null)
                }
            }
        },scaffoldState = scaffoldState, modifier = Modifier.nestedScroll(nestedScrollConnectionPx)
    )
}