package me.doapps.androidprojectguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import me.doapps.androidprojectguide.activity.HomeActivity
import me.doapps.androidprojectguide.activity.LoginActivity
import me.doapps.androidprojectguide.controller.ViewController
import me.doapps.androidprojectguide.presenter.SplashPresenter

class SplashActivity : AppCompatActivity(), ViewController.ViewSplash {

    private val splashDisplayLength = 1L * 1500L
    private lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashPresenter = SplashPresenter(this, applicationContext)

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