package com.example.loginmvpexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginmvpexample.R
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.UserDataSource
import com.example.loginmvpexample.data.source.UserRepository
import com.example.loginmvpexample.data.source.local.UserLocalDataSource
import com.example.loginmvpexample.data.source.remote.UserRemoteDataSource
import com.example.loginmvpexample.ui.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UserContract.View {

    private lateinit var mUserAdapter: UserAdapter
    private lateinit var mUserRepository: UserRepository
    private lateinit var mUserPresenter: UserPresenter
    private val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mUserRepository = UserRepository.getsInstance(
            UserLocalDataSource.getsInstance(),
            UserRemoteDataSource.getsInstance()
        )
        mUserPresenter = UserPresenter(this,mUserRepository)
        mUserPresenter.setView(this)
        mUserPresenter.getUserList()
    }

    override fun sendAllUser(list: MutableList<User>) {
        mUserAdapter = UserAdapter(list,this)
        rv_users.layoutManager = manager
        rv_users.adapter = mUserAdapter
    }

    override fun onError(exception: Exception) {
        TODO("Not yet implemented")
    }
}
