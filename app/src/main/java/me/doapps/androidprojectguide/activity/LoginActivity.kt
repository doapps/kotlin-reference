package me.doapps.androidprojectguide.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.controller.ViewController
import me.doapps.androidprojectguide.extensions.isEmptyString
import me.doapps.androidprojectguide.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), ViewController.ViewLogin {

    @BindView(R.id.user_edit)
    lateinit var userEdit: EditText

    @BindView(R.id.password_edit)
    lateinit var passwordEdit: EditText

    private lateinit var loginPresenter: LoginPresenter

    private var user = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        view()
    }

    private fun view() {
        ButterKnife.bind(this)

        loginPresenter = LoginPresenter(this, applicationContext)
    }

    private fun convertData() {
        user = userEdit.isEmptyString()
        password = passwordEdit.isEmptyString()
    }

    private fun message(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    @OnClick(R.id.enter_button)
    fun veryUser() {
        convertData()
        loginPresenter.verifyUser(user, password)
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