package me.doapps.androidprojectguide.retrofit

import com.google.gson.JsonArray
import me.doapps.androidprojectguide.model.Album

class RetrofitConvert {
    companion object {

        fun convertAlbum(jsonArray: JsonArray): MutableList<Album> {
            val listAlbum = mutableListOf<Album>()

            for (x in jsonArray) {
                listAlbum.add(Album(x.asJsonObject.get("userId").asInt
                        , x.asJsonObject.get("id").asInt
                        , x.asJsonObject.get("title").asString))
            }
            return listAlbum
        }
    }
}