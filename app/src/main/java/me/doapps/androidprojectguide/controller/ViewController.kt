package me.doapps.androidprojectguide.controller

import me.doapps.androidprojectguide.model.Album

interface ViewController {

    interface ViewSplash {
        fun login()
        fun home()
    }

    interface ViewLogin {
        fun correctUser()
        fun wrongUser(message: String)
        fun emptyUserFields(message: String)
    }

    interface ViewHome {
        fun listCategory(listString: MutableList<String>)
    }

    interface ViewListConnection {
        fun listAlbum(albums: MutableList<Album>)
        fun messageError(message: String)
    }
}