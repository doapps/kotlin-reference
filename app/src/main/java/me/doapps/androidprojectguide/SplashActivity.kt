package me.doapps.androidprojectguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import me.doapps.androidprojectguide.activity.LoginActivity

class SplashActivity : AppCompatActivity() {

    private val splashDisplayLength = 1L * 1500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        }, splashDisplayLength)
    }
}