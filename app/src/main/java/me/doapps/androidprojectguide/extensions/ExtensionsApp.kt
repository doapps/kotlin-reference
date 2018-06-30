package me.doapps.androidprojectguide.extensions

import android.text.TextUtils
import android.widget.EditText

fun EditText.isEmptyString() = if (!TextUtils.isEmpty(this.text.toString())) this.text.toString() else ""

infix fun String.compare(text: String) = this == text