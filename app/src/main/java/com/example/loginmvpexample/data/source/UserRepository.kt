package com.example.loginmvpexample.data.source

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.local.UserLocalDataSource
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener
import com.example.loginmvpexample.data.source.remote.UserRemoteDataSource

class UserRepository(
    private val mUserLocalDataSource: UserLocalDataSource,
    private val mUserRemoteDataSource: UserRemoteDataSource
){
    private object HOLDER {
        val INSTANCE = UserRepository(
            mUserLocalDataSource = UserLocalDataSource.instance,
            mUserRemoteDataSource = UserRemoteDataSource.instance)
    }

     fun getData(listener: OnFetchDataJsonListener<User>) {
        mUserRemoteDataSource.getData(listener)
    }
    companion object{
        val instance: UserRepository by lazy {HOLDER.INSTANCE}
    }

}