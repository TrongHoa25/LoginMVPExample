package com.example.loginmvpexample.data.source.remote

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.UserDataSource
import com.example.loginmvpexample.data.source.remote.fetchjson.GetDataJson

class UserRemoteDataSource :UserDataSource.RemoteDataSource{
    companion object {
        var sInstance: UserRemoteDataSource? = null
        fun getsInstance(): UserRemoteDataSource {
            if (sInstance == null) {
                sInstance = UserRemoteDataSource()
            }
            return sInstance!!
        }
    }

    override fun getData(listener: OnFetchDataJsonListener<User>) {
        val getDataJson: GetDataJson = GetDataJson(listener)
        getDataJson.getData()
    }
}