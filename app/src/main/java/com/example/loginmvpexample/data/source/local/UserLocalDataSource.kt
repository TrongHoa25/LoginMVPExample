package com.example.loginmvpexample.data.source.local

import com.example.loginmvpexample.data.source.UserDataSource

class UserLocalDataSource: UserDataSource.LocalDataSource {
    companion object {
        var sInstance: UserLocalDataSource? = null
        fun getsInstance(): UserLocalDataSource {
            if (sInstance == null) {
                sInstance = UserLocalDataSource()
            }
            return sInstance!!
        }
    }
}