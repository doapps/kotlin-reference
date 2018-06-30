package me.doapps.androidprojectguide.session

import android.content.Context
import android.content.SharedPreferences

object Preference {

    private const val preferenceName = "kotlinDemo"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun instance(context: Context): Preference {
        sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        return this
    }

    var sessionStatus: Boolean
        get() = sharedPreferences.getBoolean("sessionStatus", false)
        set(value) {
            editor.putBoolean("sessionStatus", value).commit()
        }
}