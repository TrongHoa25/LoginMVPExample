package com.example.loginmvpexample.ui.main

import android.content.Context
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.utils.BasePresenter

class UserContract {
    interface View {
        fun sendAllUser(list: MutableList<User>)
        fun onError(exception: Exception)
    }

    interface Presenter: BasePresenter<View> {
        fun getUserList()
    }
}
