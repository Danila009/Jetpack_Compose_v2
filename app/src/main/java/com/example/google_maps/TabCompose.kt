package com.example.google_maps

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class TabPage(val icon:ImageVector){
    Home(Icons.Default.Home),
    Search(Icons.Default.Search),
    Profile(Icons.Default.Person),
    Settings(Icons.Default.Settings)
}

@Composable
fun TabRowFun(selectedTabIndex: Int, onSelectedTab:(TabPage)->Unit) {
    
    TabRow(selectedTabIndex = selectedTabIndex, contentColor = Color.Red) {
        TabPage.values().forEachIndexed { index, tabPage ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onSelectedTab(tabPage) },
                text = { Text(text = tabPage.name) },
                icon = { Icon(imageVector = tabPage.icon, contentDescription = null)},
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.DarkGray
            )
        }
    }
}