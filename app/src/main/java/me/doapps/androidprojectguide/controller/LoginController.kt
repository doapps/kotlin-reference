package me.doapps.androidprojectguide.controller

interface LoginController {
    fun correctUser()
    fun wrongUser(message: String)
    fun emptyUserFields(message: String)
}