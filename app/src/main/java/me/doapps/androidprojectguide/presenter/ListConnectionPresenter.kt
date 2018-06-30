package me.doapps.androidprojectguide.presenter

import com.google.gson.JsonArray
import me.doapps.androidprojectguide.controller.ViewController
import me.doapps.androidprojectguide.retrofit.RetrofitConvert
import me.doapps.androidprojectguide.retrofit.Service
import me.doapps.androidprojectguide.retrofit.config.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListConnectionPresenter constructor(private val viewListConnection: ViewController.ViewListConnection) {

    private val api = RetrofitConfig.instanceClient().create(Service::class.java)

    fun listAlbum() {
        api.listAlbums().enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<JsonArray>?, response: Response<JsonArray>?) {
                viewListConnection.listAlbum(RetrofitConvert.convertAlbum(response?.body()!!))
            }
        })
    }
}