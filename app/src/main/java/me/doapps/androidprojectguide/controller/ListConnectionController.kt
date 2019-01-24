package me.doapps.androidprojectguide.controller

import me.doapps.androidprojectguide.model.Album

interface ListConnectionController {
    fun listAlbum(albums: MutableList<Album>)
    fun messageError(message: String)
}