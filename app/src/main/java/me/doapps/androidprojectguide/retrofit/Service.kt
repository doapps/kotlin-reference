package me.doapps.androidprojectguide.retrofit

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("albums")
    fun listAlbums(): Call<JsonArray>

}