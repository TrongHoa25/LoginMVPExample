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

    companion object {
        private lateinit var instance: UserPresenter
        fun getInstance(activity: Activity, userRepositoy: UserRepository): UserPresenter {
            if (instance == null) {
                instance = UserPresenter(activity, userRepositoy)
            }
            return instance
        }
    }
    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

}