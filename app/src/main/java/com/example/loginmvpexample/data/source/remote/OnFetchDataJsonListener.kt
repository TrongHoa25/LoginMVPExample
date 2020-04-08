package com.example.loginmvpexample.data.source.remote

interface OnFetchDataJsonListener<T> {
    fun onSuccess(data: List<T>?)
    fun onError(e: Exception?)
}
