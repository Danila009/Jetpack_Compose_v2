package com.example.google_maps

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.google_maps.ui.theme.Google_MapsTheme
import com.example.google_maps.ui.theme.Purple500
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import java.lang.Exception

class BarCodeAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val barCodeGenerate = remember { mutableStateOf("") }
            val bitmap = remember { mutableStateOf<Bitmap?>(null) }

            Google_MapsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp, 15.dp, 15.dp, 0.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        bitmap.value?.asImageBitmap()?.let { it ->
                            Image(
                                bitmap = it,
                                contentDescription = null,
                                modifier = Modifier.size(250.dp)
                            )
                        }
                        OutlinedTextField(
                            value = barCodeGenerate.value,
                            onValueChange = { barCodeGenerate.value = it },
                            label = { Text(text = "TextCode") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Button(
                            onClick = {
                                if (barCodeGenerate.value != ""){
                                    bitmap.value = generateBarCode(barCodeGenerate.value)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .height(60.dp)
                                .padding(10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Purple500)
                        ) {
                            Text(
                                text = "Code",
                                color = androidx.compose.ui.graphics.Color.White,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

fun generateBarCode(text: String): Bitmap {
    val width = 500
    val height = 150
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val codeWriter = MultiFormatWriter()

    val bitMatrix = codeWriter.encode(
        text,
        BarcodeFormat.CODE_128,
        width,
        height
    )

    for (x in 0 until width) {
        for (y in 0 until height) {
            val color = if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
            bitmap.setPixel(x, y, color)
        }
    }

    return bitmap
}