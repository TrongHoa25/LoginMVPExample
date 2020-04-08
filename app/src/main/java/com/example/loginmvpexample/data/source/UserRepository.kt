package com.example.loginmvpexample.data.source

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.local.UserLocalDataSource
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener
import com.example.loginmvpexample.data.source.remote.UserRemoteDataSource

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
){

    private object HOLDER {
        val INSTANCE = UserRepository(
            userLocalDataSource = UserLocalDataSource.instance,
            userRemoteDataSource = UserRemoteDataSource.instance)
    }

     fun getData(listener: OnFetchDataJsonListener<User>) {
        userRemoteDataSource.getData(listener)
    }

    companion object{
        val instance: UserRepository by lazy {HOLDER.INSTANCE}
    }
}
