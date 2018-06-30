package me.doapps.androidprojectguide.presenter

import me.doapps.androidprojectguide.controller.ViewController
import me.doapps.androidprojectguide.extensions.compare

class LoginPresenter constructor(private val viewLogin: ViewController.ViewLogin) {

    fun verifyUser(user: String, password: String) {
        if (user.isEmpty() || password.isEmpty()) {
            viewLogin.emptyUserFields("Ingrese datos del usuario")
        } else if (user compare "Doapps" && password compare "Doapps") {
            viewLogin.correctUser()
        } else {
            viewLogin.wrongUser("Contraseña invalida")
        }
    }
}