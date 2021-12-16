package com.example.google_maps

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.google_maps.Json.GET
import com.example.google_maps.ui.theme.Google_MapsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.text.SimpleDateFormat
import java.util.ArrayList


class RecuclerView : ComponentActivity() {
    var counter = 0
    var image: ImageBitmap?=null
    var bitmap:Bitmap?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val str = remember {
                mutableStateOf("photo")
            }

            val index = remember {
                mutableStateOf("index")
            }
            //val listTitle = ArrayList<String>()

            val count = remember {
                mutableStateOf(0)
            }
            var arraYY = remember {
                JSONArray()
            }

            var nameRem = remember {
                mutableStateOf(true)
            }
            val hi = remember{ mutableStateOf("Hello") }

            Column {

                if (!nameRem.value){
                    CircularProgressIndicator(color = Color.Black)
                    Log.d("sdfs",nameRem.value.toString())
                }


                    MainScope().launch {
                        val array = GET.get().await()
                        hi.value = array.getJSONObject(0).getString("firstName")
                        arraYY = array
                        count.value = arraYY.length()
                    }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxSize()) {
                    Column(Modifier.fillMaxWidth()
                    ) {
                        LazyColumn(
                            Modifier
                                .scrollable(rememberLazyListState(), Orientation.Vertical)
                                .fillMaxWidth()){


                            for(i in 0 until count.value){
                                item {
                                    val name = arraYY.getJSONObject(i).getString("firstName")
                                    val name1 = arraYY.getJSONObject(i).getString("lastName")
                                    val name2 = arraYY.getJSONObject(i).getString("middleName")
                                    val Description = arraYY.getJSONObject(i).getString("description")
                                    val deadDate = arraYY.getJSONObject(i).getString("deadDate")
                                    val birthDate = arraYY.getJSONObject(i).getString("birthDate")
                                    //val formatter =SimpleDateFormat("yyyy-MM-dd")
                                    //if (deadDate!= null){
                                    //    deadDate = formatter.parse(deadDate).toString()
                                    //}
                                    //if (birthDate!= null){
                                    //    birthDate = formatter.parse(birthDate).toString()
                                    //}
                                    val id = arraYY.getJSONObject(i).getString("id")
                                    val photo = Base64.decode((arraYY.getJSONObject(i).getString("photo")), Base64.NO_WRAP)
                                    var Description0 = ""
                                    if (Description.length>=100){
                                        Description0 = Description.replaceRange(
                                            101 until Description.length,
                                            "..."
                                        )
                                    }
                                    Chel(id.toInt(),name,photo,Description0,
                                        Description,name1,name2,birthDate,deadDate)

                                }
                            }
                        }
                    }
                }
            }
        }
    }
    @Composable
    fun Chel(id:Int,
             name:String,
             image:ByteArray,
             Description:String,
             Description0: String,
             name1:String,
             name2: String,
             birthDate:String,
             deadDate:String) {

        val a = BitmapFactory.decodeByteArray(image,0,image.size)
        val b = a.asImageBitmap()

        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        val intent = Intent(this@RecuclerView, MoreDetails::class.java).apply {

                            if (deadDate == "null") {
                                putExtra("Date", birthDate)
                            } else {
                                putExtra("Date", "$birthDate - $deadDate")
                            }

                            putExtra("name", "$name $name1 $name2")
                            putExtra("image", image)
                            putExtra("Description", Description0)
                            putExtra("Id", id)
                        }
                        startActivity(intent)
                    })
                },
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
            Row {
                ImageList(b)
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {

                    Text(text = "$name $name1 $name2", style = typography.h6)

                    Text(text = Description, style = typography.caption  )
                }
            }
        }
    }


    @Composable
    private fun ImageList(bitmap: ImageBitmap) {
        Image(bitmap = bitmap,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(84.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp))))
    }
}
