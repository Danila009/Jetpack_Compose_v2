package com.example.google_maps.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.google_maps.Greeting2

@ExperimentalFoundationApi
@Composable
fun ListScreen(navController: NavController) {

    Scaffold(content = {
        Greeting2(onClick = {
            navController.navigate("search")
        })
    })
}