package me.doapps.androidprojectguide.controller

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
}