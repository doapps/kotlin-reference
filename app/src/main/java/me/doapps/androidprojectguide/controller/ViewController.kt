package me.doapps.androidprojectguide.controller

interface ViewController {

    interface ViewLogin {
        fun correctUser()
        fun wrongUser(message: String)
        fun emptyUserFields(message: String)
    }
}