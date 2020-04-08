package com.example.loginmvpexample.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loginmvpexample.ui.main.MainActivity
import com.example.loginmvpexample.R
import com.example.loginmvpexample.data.source.UserRepository
import com.example.loginmvpexample.data.source.remote.UserRemoteDataSource
import com.example.loginmvpexample.ui.main.UserPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View, View.OnClickListener {
    private lateinit var loginPresenter: LoginPresenter
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userRepository = UserRepository.instance
        loginPresenter = LoginPresenter(userRepository)
    }

    override fun loginSuccess() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun loginFail() {
        Toast.makeText(this,"Your email or your password not correct!!", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.buttonRegisterLogin ->
                loginPresenter.onLogin(editTextEmail.text.toString(), editTextPassword.text.toString())
        }
    }
}
