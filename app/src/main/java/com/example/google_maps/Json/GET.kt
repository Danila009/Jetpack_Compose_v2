package com.example.google_maps.Json

import com.google.gson.JsonArray
import kotlinx.coroutines.*
import org.json.JSONArray
import java.net.CacheResponse
import java.net.HttpURLConnection
import java.net.URL

class GET {
    companion object{
        val Url = "https://api.cfif31.ru/Library/Autors"

        fun get(): Deferred<JSONArray> = CoroutineScope(Dispatchers.IO).async{

                val connection = URL(Url).openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connect()
                val jsonStr = connection.inputStream.bufferedReader().readText()
                return@async JSONArray(jsonStr)
        }
    }
}