package com.example.google_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.google_maps.screens.ListScreen
import com.example.google_maps.screens.PushScreen
import com.example.google_maps.screens.SearchScreen
import com.example.google_maps.ui.theme.Google_MapsTheme

class Navigation : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Google_MapsTheme {

                val bootinBar = listOf("list","search","push")
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            bootinBar.forEach { screen ->

                                BottomNavigationItem(selected = false, onClick = {

                                    navController.navigate(screen)

                                }, label = { Text(screen)}, icon = {

                                })
                            }
                        }
                    },
                    content = {
                        NavHost(navController = navController, startDestination = "list"){
                            composable("list"){ListScreen(navController)}
                            composable("search"){SearchScreen()}
                            composable("push"){PushScreen()}
                        }
                    }
                )
            }
        }
    }
}
