package me.doapps.androidprojectguide.presenter

import android.content.Context
import me.doapps.androidprojectguide.controller.LoginController
import me.doapps.androidprojectguide.controller.ViewController
import me.doapps.androidprojectguide.extensions.compare
import me.doapps.androidprojectguide.session.Preference

class LoginPresenter constructor(private val viewLogin: LoginController, context: Context) {

    private val preference = Preference.instance(context)

    fun verifyUser(user: String, password: String) {
        if (user.isEmpty() || password.isEmpty()) {
            viewLogin.emptyUserFields("Ingrese datos del usuario")
        } else if (user compare "Doapps" && password compare "Doapps") {
            preference.sessionStatus = true
            viewLogin.correctUser()
        } else {
            viewLogin.wrongUser("Contraseña invalida")
        }
    }
}