package com.example.loginmvpexample.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginmvpexample.ui.main.MainActivity
import com.example.loginmvpexample.R
import com.example.loginmvpexample.data.source.UserRepository
import com.example.loginmvpexample.data.source.local.UserLocalDataSource
import com.example.loginmvpexample.data.source.remote.UserRemoteDataSource
import com.example.loginmvpexample.ui.main.UserPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var mLoginPresenter: LoginPresenter
    private lateinit var mUserRepository: UserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mUserRepository = UserRepository.getsInstance(
            UserLocalDataSource.getsInstance(),
            UserRemoteDataSource.getsInstance()
        )
        mLoginPresenter = LoginPresenter(mUserRepository)
        btn_register_login.setOnClickListener {
            mLoginPresenter.handleLogin(edt_email_login.text.toString().trim(), edt_password_login.toString().trim())
        }
    }

    override fun loginSuccess() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun loginFail() {
        Toast.makeText(this,"Your email or your password not correct!!",Toast.LENGTH_SHORT).show()
    }

}
