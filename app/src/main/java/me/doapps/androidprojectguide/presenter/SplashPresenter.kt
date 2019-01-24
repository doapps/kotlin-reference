package me.doapps.androidprojectguide.presenter

import android.content.Context
import me.doapps.androidprojectguide.controller.SplashController
import me.doapps.androidprojectguide.session.Preference

class SplashPresenter constructor(private val viewSplash: SplashController, context: Context) {

    private val preference = Preference.instance(context)

    fun verifySession() {
        if (!preference.sessionStatus) {
            viewSplash.login()
        } else {
            viewSplash.home()
        }
    }
}