package com.example.google_maps.Retrofit

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers


interface AvtorAPI {

    @GET("./Autors")
    @Headers("Content-Type: application/json")
    fun getAvtorList():Single<AvtorList>
}