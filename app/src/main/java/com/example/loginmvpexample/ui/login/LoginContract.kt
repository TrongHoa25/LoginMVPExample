package com.example.loginmvpexample.ui.login

import android.text.Editable
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.utils.BasePresenter

class LoginContract {

    interface View {
        fun loginSuccess()
        fun loginFail()
    }

    interface Presenter: BasePresenter<View> {
        fun onLogin(email: String, password: String)
    }
}
