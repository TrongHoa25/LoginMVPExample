package com.example.loginmvpexample.data.source

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener

interface UserDataSource {
    interface LocalDataSource {

    }
    interface RemoteDataSource {
        fun getData(listener: OnFetchDataJsonListener<User>)
    }
}