package com.example.google_maps.Retrofit.RetrofitClass

import android.graphics.Movie
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("./Library/Autors")
    fun getMovieList(): Call<MutableList<Movie>>
}