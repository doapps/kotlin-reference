package me.doapps.androidprojectguide.presenter

import android.app.Activity
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.controller.HomeController
import me.doapps.androidprojectguide.controller.ViewController

class HomePresenter constructor(private val viewHome: HomeController) {

    fun listCategory(activity: Activity) {
        viewHome.listCategory(listTitleCategory(activity))
    }

    private fun listTitleCategory(activity: Activity): MutableList<String> {
        return mutableListOf(activity.getString(R.string.register_user_button)
                , activity.getString(R.string.list_user_button)
                , activity.getString(R.string.verify_list_button)
                , activity.getString(R.string.download_list_button))
    }
}