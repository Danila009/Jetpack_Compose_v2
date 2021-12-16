package com.example.google_maps.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val gradientColor1 = Color(0xFF642B73)
val gradientColor2 = Color(0xFFC6426E)
@SuppressLint("MissingColorAlphaChannel")
val transparent  = Color(0xFFFFFF)



val DarkColors = darkColors(
    primary = Purple200,
    secondary = Teal200
)

val LightColors = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)
