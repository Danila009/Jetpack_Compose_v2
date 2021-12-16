
package com.example.google_maps

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import kotlin.random.Random
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import com.example.google_maps.Json.Autor
import com.example.google_maps.Json.GET
import com.example.google_maps.ui.theme.Google_MapsTheme
import kotlinx.coroutines.*
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class ApiAct : ComponentActivity() {

    var a =""

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bitmapUri: MutableLiveData<Uri> = MutableLiveData<Uri>()
        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            bitmapUri.value = uri
        }

        var simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        var calendar: Calendar = Calendar.getInstance()

        MainScope().launch {
            val JsonStr = GET.get().await()
            a = JsonStr.getJSONObject(0).getString("firstName")
            val photo = JsonStr.getJSONObject(0).getString("photo")
            val byteArray = Base64.decode(photo,Base64.NO_WRAP)
            val bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
          //  val image =bitmap.asImageBitmap()
        }


        setContent {
            val showDialog = remember { mutableStateOf("") }
            val date = remember {
                mutableStateOf("null")
            }
            val dpd = DatePickerDialog(this,
                { view, thisYear, thisMonth, thisDay ->
                    date.value = "$thisYear-$thisMonth-$thisDay"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            Google_MapsTheme {
                Surface(color = MaterialTheme.colors.background) {

                    Column {
                        Button(onClick = {

                            dpd.show()

                        }) {
                            Text(text = date.value)                    }
                        //Image(bitmap = image, contentDescription = null)

                        Button(onClick = {
                            MainScope().launch{
                                //Получим данные с сервера и выдадим в EditText
                                val content = GetHttpContent().await()
                                val dAte:Date?=null

                                date.value = Autor.getList().await().toString()

                                Log.d("sfdfs", date.value)
                            }
                        }) {
                            Text(text = "Byr")
                        }

                        Button(onClick = {
                            //Dispatchers.Main - нужен для вызова ассинхронных методов в ГЛАВНОМ потоке интерфейса
                            CoroutineScope(Dispatchers.Main).launch {
                                //Для того чтобы "дождаться" информации из асинхронного потока
                                //используется метод await()
                                val testVal = TestValExample().await()
                                //Когда мы дождемся результат - можно вывести его
                                date.value = testVal.toString()
                                Log.d("sfdfs", testVal.toString())
                            }
                        }) {
                            Text(text = date.value)
                        }
                    }
                }
            }
        }
    }

    //Наш метод будет обращаться к сети, чтобы получть данные
    fun GetHttpContent(): Deferred<String> = CoroutineScope(Dispatchers.IO).async{
        //Чтобы обращения к сети работали - для начала воспользуемся простейшим методом URL(url).GetText()
        //Но чтобы сеть работала - нужно в манифесте прописать разрешение на использование сети
        return@async URL("https://api.cfif31.ru/library/autors/1").readText()
    }
    //Создадим ассинхронную задачу, которая в ходе своего выполнения вернет число
    //(CoroutineScope можно привязать к методу)
    fun TestValExample(): Deferred<Int> = CoroutineScope(Dispatchers.Default).async {
        delay(10000)
        return@async Random.nextInt()
    }
    
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Google_MapsTheme {
        Greeting("Android")
    }
}