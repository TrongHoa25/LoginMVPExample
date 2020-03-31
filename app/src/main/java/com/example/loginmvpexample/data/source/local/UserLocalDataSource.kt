package com.example.loginmvpexample.data.source.local

import com.example.loginmvpexample.data.source.UserDataSource

class UserLocalDataSource: UserDataSource.LocalDataSource {
    private object HOLDER {
        val INSTANCE = UserLocalDataSource()
    }
    companion object {
        val instance: UserLocalDataSource by lazy { HOLDER.INSTANCE}
    }
}