package com.example.loginmvpexample.data.source

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.local.UserLocalDataSource
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener
import com.example.loginmvpexample.data.source.remote.UserRemoteDataSource

class UserRepository(
    private val mUserLocalDataSource: UserLocalDataSource,
    private val mUserRemoteDataSource: UserRemoteDataSource
): UserDataSource.LocalDataSource, UserDataSource.RemoteDataSource {
    companion object {
        private var sInstance: UserRepository? = null
        fun getsInstance(
            mUserLocalDataSource: UserLocalDataSource,
            mUserRemoteDataSource: UserRemoteDataSource
        ): UserRepository {
            if (sInstance == null) {
                sInstance = UserRepository(mUserLocalDataSource, mUserRemoteDataSource)
            }
            return sInstance!!
        }
    }

    //remote

    override fun getData(listener: OnFetchDataJsonListener<User>) {
        mUserRemoteDataSource.getData(listener)
    }

}