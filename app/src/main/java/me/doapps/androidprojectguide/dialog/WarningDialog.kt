package me.doapps.androidprojectguide.dialog

import android.app.Activity
import android.app.AlertDialog
import me.doapps.androidprojectguide.R
import kotlinx.android.synthetic.main.dialog_warning.view.*


class WarningDialog constructor(private val activity: Activity ) {

    private lateinit var builder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog
    private var inflater = activity.layoutInflater

    private lateinit var accept: Accept
    lateinit var message: String

    fun show() {
        builder = AlertDialog.Builder(activity)
        val view = inflater.inflate(R.layout.dialog_warning, null)
        builder.setView(view)

        view.messageText.text = message

        view.messageButton.setOnClickListener {
            accept.acceptOption()
        }

        alertDialog = builder.create()
        alertDialog.show()
    }

    fun cancel() {
        alertDialog.cancel()
    }

    interface Accept {
        fun acceptOption()
    }

    fun setOnclickAccept(accept: Accept) {
        this.accept = accept
    }
}