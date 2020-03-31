package com.example.loginmvpexample.ui.login

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.UserRepository
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener

class LoginPresenter(private var mUserRepository: UserRepository) : LoginContract.Presenter {
    private lateinit var mView: LoginContract.View
    override fun handleLogin(email: String, password: String) {
        mUserRepository.getData(object : OnFetchDataJsonListener<User> {
            override fun onSuccess(data: List<User>?) {
                if (compare(email, password, data!!)){
                    mView.loginSuccess()
                } else {
                    mView.loginFail()
                }
            }

            override fun onError(e: Exception?) {
            }

        })
    }

    override fun onStart() {

    }

    override fun onStop() {

    }

    override fun setView(view: LoginContract.View) {

    }
    fun compare(email: String, password: String, data: List<User>): Boolean{
        for (user in data!!){
            if (email.equals(user.email) && password.equals(user.password)){
                return true
            }
        }
        return false
    }
}