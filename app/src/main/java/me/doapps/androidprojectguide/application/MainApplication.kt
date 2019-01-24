package me.doapps.androidprojectguide.application

import android.app.Application
import me.doapps.androidprojectguide.module.*
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(layoutManagerModule, splashModule, homeModule,
                loginModule, listConnectionModule))
    }
}