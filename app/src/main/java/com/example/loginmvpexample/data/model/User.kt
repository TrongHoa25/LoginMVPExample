package com.example.loginmvpexample.data.model

import java.io.Serializable
class User : Serializable {
    var email: String? = null
    var password: String? = null

    constructor(userBuilder: UserBuilder) {
        email = userBuilder.mEmail
        password = userBuilder.mPassword
    }

    constructor() {}

    class UserBuilder {
        var mEmail: String? = null
        var mPassword: String? = null

        constructor(email: String?, password: String?) {
            mEmail = email
            mPassword = password
        }

        constructor() {}

        fun email(email: String?): UserBuilder {
            mEmail = email
            return this
        }

        fun password(password: String?): UserBuilder {
            mPassword = password
            return this
        }


        fun build(): User {
            return User(this)
        }
    }

    object UserEntry {
        const val USER = "results"
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}