package com.example.loginmvpexample.ui.main

import android.app.Activity
import android.os.Debug
import android.util.Log
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.UserRepository
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener

class UserPresenter(private val activity: Activity,
                    private val userRepository: UserRepository) : UserContract.Presenter{

    private lateinit var view: UserContract.View
    override fun getUserList() {
        userRepository.getData(object : OnFetchDataJsonListener<User>{

            override fun onSuccess(data: List<User>?) {
                    view.sendAllUser(data as MutableList<User>)
            }

            override fun onError(e: Exception?) {
            }

        })
    }

    override fun setView(view: UserContract.View) {
        this.view = view
    }

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }
}
