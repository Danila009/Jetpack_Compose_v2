package com.example.google_maps.Retrofit

import com.google.gson.annotations.SerializedName

data class AvtorList(val items: List<AvtorListItem>)

data class AvtorListItem(

    @SerializedName("firstName")
    val firstName:String,

    @SerializedName("description")
    val description: String,

    @SerializedName("photo")
    val photo:String
)