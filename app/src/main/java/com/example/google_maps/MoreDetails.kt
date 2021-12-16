package com.example.google_maps

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.google_maps.Json.DELETE
import com.example.google_maps.ui.theme.Google_MapsTheme
import java.text.SimpleDateFormat

class MoreDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent= intent
        setContent {
            Google_MapsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Design()
                }
            }
        }
    }
    @Composable
    fun Design() {
        val context = LocalContext.current

        val name = intent.getStringExtra("name").toString()
        val Description = intent.getStringExtra("Description").toString()
        val date = intent.getStringExtra("Date").toString()
        val id = intent.getStringExtra("Id").toString()
        val image = intent.getByteArrayExtra("image")



        val a = BitmapFactory.decodeByteArray(image,0,image!!.size)
        val b = a.asImageBitmap()

        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = name)
            },navigationIcon = {
                IconButton(onClick = {

                    val intent = Intent(context, RecuclerView::class.java)
                    context.startActivity(intent)

                }) {
                    Image(painter = painterResource(id = R.drawable.ic_baseline_chevron_left_24), contentDescription = null)
                }

            },actions = {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_autorenew_24), contentDescription = null)
                }

                IconButton(onClick = {
                    DELETE.del(id.toInt(),context)
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_delete_24), contentDescription = null)
                }
            },backgroundColor = Color.White)
        }){

            LazyColumn(Modifier.fillMaxWidth()){
                item {
                    Column(Modifier.fillMaxWidth()) {
                        Image(bitmap = b, contentDescription = null,
                            Modifier
                                .height(300.dp)
                                .fillMaxWidth()
                                .pointerInput(Unit) {
                                    detectTapGestures(onDoubleTap = {
                                        Toast
                                            .makeText(context, "OK", Toast.LENGTH_SHORT)
                                            .show()
                                    })
                                })

                        Text(text = name,
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, start = 10.dp),style = MaterialTheme.typography.h6,overflow = TextOverflow.Ellipsis)
                        Divider(modifier = Modifier.padding(bottom = 4.dp))

                        if (Description != "null"){
                            Text(text = Description,
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, start = 10.dp),style = MaterialTheme.typography.caption,overflow = TextOverflow.Ellipsis)
                            Divider(modifier = Modifier.padding(bottom = 4.dp))
                        }

                        Text(text = date,
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, end = 10.dp),style = MaterialTheme.typography.caption,textAlign = TextAlign.End,overflow = TextOverflow.Ellipsis)
                        Divider(modifier = Modifier.padding(bottom = 4.dp))
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview4() {
        Google_MapsTheme {
            Design()
        }
    }
}