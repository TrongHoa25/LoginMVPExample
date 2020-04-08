package com.example.loginmvpexample.data.source.remote.fetchjson

import com.example.loginmvpexample.utils.Constant
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener

class GetDataJson(private var listener: OnFetchDataJsonListener<User>?) {

    fun getData() {
        val url = Constant.BASE_URL
        GetJsonFromUrl(listener).execute(url)
    }
}
