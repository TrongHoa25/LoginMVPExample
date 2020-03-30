package com.example.loginmvpexample.ui.main

import android.app.Activity
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.UserRepository
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener

class UserPresenter(private val activity: Activity,
                    private val mUserRepository: UserRepository): UserContract.Presenter{
    private var mView: UserContract.View? = null
    override fun getUserList() {
        mUserRepository.getData(object : OnFetchDataJsonListener<User>{
            override fun onSuccess(data: List<User>?) {
                mView!!.sendAllUser(data as MutableList<User>)
            }

            override fun onError(e: Exception?) {

            }

        })
    }

    override fun setView(view: UserContract.View) {
        mView = view
    }

    companion object {
        private var sInstance: UserPresenter? = null

        fun getInstance(activity: Activity, mUserRepositoy: UserRepository): UserPresenter {
            if (sInstance == null) {
                sInstance = UserPresenter(activity, mUserRepositoy)
            }
            return sInstance!!
        }
    }
    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

}