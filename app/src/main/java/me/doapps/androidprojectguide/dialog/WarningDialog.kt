package me.doapps.androidprojectguide.dialog

import android.app.Activity
import android.app.AlertDialog
import android.widget.Button
import android.widget.TextView
import me.doapps.androidprojectguide.R

class WarningDialog constructor(private val activity: Activity, private val message: String) {

    private lateinit var builder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog
    private var inflater = activity.layoutInflater

    private lateinit var accept: Accept

    fun show() {
        builder = AlertDialog.Builder(activity)
        val view = inflater.inflate(R.layout.dialog_warning, null)
        builder.setView(view)

        val messageText = view.findViewById<TextView>(R.id.message_text)
        messageText.text = message

        val messageButton = view.findViewById<Button>(R.id.message_button)
        messageButton.setOnClickListener({
            accept.acceptOption()
        })

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