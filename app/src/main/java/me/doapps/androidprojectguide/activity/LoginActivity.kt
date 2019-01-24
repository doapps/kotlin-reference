package me.doapps.androidprojectguide.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.controller.LoginController
import me.doapps.androidprojectguide.extensions.isEmptyString
import me.doapps.androidprojectguide.presenter.LoginPresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginController {

    private val loginPresenter: LoginPresenter by inject { parametersOf(this) }

    private var user = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        view()
    }

    private fun view() {
        enterButton.setOnClickListener {
            convertData()
            loginPresenter.verifyUser(user, password)
        }
    }

    private fun convertData() {
        user = userEdit.isEmptyString()
        password = passwordEdit.isEmptyString()
    }

    private fun message(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun correctUser() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun wrongUser(message: String) {
        message(message)
    }

    override fun emptyUserFields(message: String) {
        message(message)
    }
}