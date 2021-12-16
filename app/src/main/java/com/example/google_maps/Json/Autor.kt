package com.example.google_maps.Json

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Base64.encodeToString
import android.util.Log
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class Autor(
    val Id:Int,
    var FirstName:String,
    val LastName:String,
    val MiddleName:String?,
    val BirthDate: Date,
    val DeadDate: Date?,
    val Description:String,
    val Photo:ByteArray?
) {

    fun GetPhoto(): Bitmap? {
        if (Photo != null)
            return BitmapFactory.decodeByteArray(Photo, 0, Photo.size)
        return null
    }

    fun genJson(): JSONObject {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val json = JSONObject()
        json.put("id", Id)
        json.put("firstName", FirstName)
        json.put("lastName", LastName)
        json.put("middleName", MiddleName)
        json.put("birthDate", simpleDateFormat.format(BirthDate))
        DeadDate?.let { json.put("deadDate", simpleDateFormat.format(DeadDate)) }
        json.put("description", Description)
        //Если фото не пустое
        Photo?.let {
            json.put("photo", Base64.encodeToString(Photo, Base64.NO_WRAP))
        }

        return json
    }

    //Добавление данных
    fun Post() = CoroutineScope(Dispatchers.IO).launch {
        //Открываем соединение
        val content =
            URL("https://api.cfif31.ru/library/autors").openConnection() as HttpURLConnection
        //Тип данных - JSON
        content.addRequestProperty("Content-Type", "Application/Json")
        //Метод - POST (отправка - добавление)
        content.requestMethod = "POST"
        //Врайтер данных
        val writer = content.outputStream.bufferedWriter()
        //Пишем JSON
        writer.write(genJson().toString())
        //Обнуляем поток (производим запись из врайтера в поток)
        writer.flush()
        content.outputStream.flush()
        //Отправляем данные
        content.connect()

        //Читаем коды результата (Можно вернуть через Async)
        //Если данные добавлены - будет код 202
        Log.d("Test", content.responseCode.toString())
        Log.d("Test", content.responseMessage.toString())
    }

    //Изменение данных
    fun Put() = CoroutineScope(Dispatchers.IO).launch {
        //Передаем через /ID автора
        val content =
            URL("https://api.cfif31.ru/library/autors/" + Id).openConnection() as HttpURLConnection
        content.addRequestProperty("Content-Type", "Application/Json")
        //Метод PUT - для изменения данных
        content.requestMethod = "PUT"
        val writer = content.outputStream.bufferedWriter()
        writer.write(genJson().toString())
        writer.flush()
        content.outputStream.flush()
        content.connect()

        //200
        Log.d("Test", content.responseCode.toString())
        Log.d("Test", content.requestMethod.toString())
    }

    fun Delete() = CoroutineScope(Dispatchers.IO).launch {
        //Передаем через /ID автора
        val content = URL("https://api.cfif31.ru/library/autors/" + Id).openConnection() as HttpURLConnection
        //Метод DELETE - для изменения данных
        content.requestMethod = "DELETE"
        content.connect()

        //204
        Log.d("Test", content.responseCode.toString())
        Log.d("Test", content.responseMessage.toString())
    }
    companion object{
        suspend fun getList(): Deferred<MutableList<Autor>> = CoroutineScope(Dispatchers.IO).async{
            val list = mutableListOf<Autor>()
            val content = URL("https://api.cfif31.ru/library/autors").readText()
            val array = JSONArray(content)
            for (i in 0 until array.length()){
                list.add(fromJson(array.getJSONObject(i)))
            }
            return@async list
        }
        //Чтобы не городить проверки - напишем метод расширяющий возможности класса SimpleDateFormat
        //tryParse - метод будет ПЫТАТЬСЯ вытащить из строки дату.
        //Если удастся - вернется дата. Иначе вернется null
        fun SimpleDateFormat.tryParse(strDate:String):Date?{
            try {
                return parse(strDate)
            }catch (ex:Exception){
                return null
            }
        }
        //Получение данных об ОДНОМ авторе
        fun fromJson(jsonObject: JSONObject):Autor{
            //Формат пришедшей даты
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            //Создаем автора
            val autor = Autor(
                //Передаем в него поля JSON, получая их с нужным типом
                jsonObject.getInt("id"),
                jsonObject.getString("firstName"),
                jsonObject.getString("lastName"),
                jsonObject.getString("middleName"),
                dateFormat.tryParse(jsonObject.getString("birthDate"))!!,
                dateFormat.tryParse(jsonObject.getString("deadDate")),
                jsonObject.getString("description"),
                Base64.decode(jsonObject.getString("photo"), Base64.DEFAULT)
            )
            return autor
        }
    }

}