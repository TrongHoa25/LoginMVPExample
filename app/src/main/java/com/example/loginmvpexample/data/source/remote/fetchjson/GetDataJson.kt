package com.example.loginmvpexample.data.source.remote.fetchjson

import com.example.loginmvpexample.utils.Constant
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener

class GetDataJson(private var mListener: OnFetchDataJsonListener<User>?) {

    fun getData() {
        val url = Constant.BASE_URL
        GetJsonFromUrl(mListener).execute(url)
    }

}
