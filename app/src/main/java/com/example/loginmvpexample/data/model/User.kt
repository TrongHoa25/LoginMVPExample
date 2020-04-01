package com.example.loginmvpexample.data.model

data class User(
    var email: String = "",
    var password: String = ""
)
object UserEntry {
    const val USER = "results"
    const val EMAIL = "email"
    const val PASSWORD = "password"
}
