package com.example.google_maps

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.google_maps.ui.theme.Google_MapsTheme

class ShimmerAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val shim = remember { mutableStateOf(false)}

            val timer = object:CountDownTimer(8000,1000){
                override fun onTick(p0: Long) {

                }

                override fun onFinish() {
                    shim.value = true
                }

            }
            timer.start()

            Google_MapsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn{
                        item {
                            Column {
                                repeat(100){
                                    if (!shim.value){
                                        AnimatedShimmer()
                                    }else{
                                        Item()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Item() {
    Card(shape = AbsoluteRoundedCornerShape(20.dp),elevation = 2.dp, modifier = Modifier.padding(4.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
                .width(300.dp)
                .height(90.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(painter = painterResource(id = R.drawable.ic_android_black_24dp),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                tint = Color.Green)

            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.Center)
            {
                Text(
                    text = "Text",
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.7f)
                    //.background(brush)

                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Text" ,
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.9f)
                    //.background(brush)
                )
            }
        }
    }
}

