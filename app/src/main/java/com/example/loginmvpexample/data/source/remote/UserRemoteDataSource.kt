package com.example.loginmvpexample.data.source.remote

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.UserDataSource
import com.example.loginmvpexample.data.source.remote.fetchjson.GetDataJson

class UserRemoteDataSource :UserDataSource.RemoteDataSource{

    private object HOLDER{
        var INTANCE = UserRemoteDataSource()
    }

    companion object{
        val instance : UserRemoteDataSource by lazy {
            HOLDER.INTANCE
        }
    }

    override fun getData(onFetchDataJsonListener: OnFetchDataJsonListener<User>) {
        val getDataJson: GetDataJson = GetDataJson(onFetchDataJsonListener)
        getDataJson.getData()
    }
}
