package com.example.google_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.google_maps.ui.theme.Google_MapsTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

class TabAct : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val pagerState = rememberPagerState(pageCount = TabPage.values().size)
            val scope = rememberCoroutineScope()

            Google_MapsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TabRowFun(
                                selectedTabIndex = pagerState.currentPage,
                                onSelectedTab = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(it.ordinal)
                                    }
                                },
                            )
                        },bottomBar = {
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                HorizontalPagerIndicator(
                                    pagerState = pagerState,
                                    activeColor = Color.Red,
                                    inactiveColor = Color.DarkGray,
                                    indicatorShape = AbsoluteRoundedCornerShape(20.dp),
                                    indicatorHeight = 16.dp,
                                    indicatorWidth = 16.dp,
                                    spacing = 32.dp
                                )
                            }
                        },content = {

                            HorizontalPager(state = pagerState) { index ->
                                Column(Modifier.fillMaxSize()) {
                                    when(index){
                                        0->{
                                            Text(text = "Hello")
                                        }
                                        1->{
                                            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                                Icon(imageVector = Icons.Default.Person, contentDescription = null, Modifier.fillMaxSize())
                                            }
                                        }
                                        2->{
                                            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                                Icon(imageVector = Icons.Default.Lock, contentDescription = null, Modifier.fillMaxSize())
                                            }
                                        }
                                        4->{

                                        }
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}