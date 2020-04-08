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

    private lateinit var userAdapter: UserAdapter
    private lateinit var userPresenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userPresenter = UserPresenter(this, UserRepository.instance)
        userPresenter.setView(this)
        userPresenter.getUserList()
    }

    override fun sendAllUser(list: MutableList<User>) {
        userAdapter = UserAdapter(list,this)
        recyclerUsers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerUsers.adapter = userAdapter
    }

    override fun onError(exception: Exception) {
        TODO("Not yet implemented")
    }
}
