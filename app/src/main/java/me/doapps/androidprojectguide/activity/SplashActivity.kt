package me.doapps.androidprojectguide.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.controller.SplashController
import me.doapps.androidprojectguide.presenter.SplashPresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashActivity : AppCompatActivity(), SplashController {

    private val splashDisplayLength = 1L * 1500L
    private val splashPresenter : SplashPresenter by inject{ parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            splashPresenter.verifySession()
        }, splashDisplayLength)
    }

    override fun login() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun home() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}