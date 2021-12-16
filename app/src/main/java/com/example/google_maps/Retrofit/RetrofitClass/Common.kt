package com.example.google_maps.Retrofit.RetrofitClass



object Common {
    private val BASE_URL = "https://api.cfif31.ru/Library/Autors"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}