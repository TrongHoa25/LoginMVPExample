package com.example.loginmvpexample.data.source.remote.fetchjson

import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.model.UserEntry
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ParseDataWithJson {
    private val TIME_OUT = 15000
    private val METHOD_GET = "GET"
    private val LOG = ParseDataWithJson::class.java.simpleName

    @Throws(Exception::class)
    fun getJsonFromUrl(urlString: String?): String? {
        val url = URL(urlString)
        val httpURLConnection =
            url.openConnection() as HttpURLConnection
        httpURLConnection.connectTimeout = TIME_OUT
        httpURLConnection.readTimeout = TIME_OUT
        httpURLConnection.requestMethod = METHOD_GET
        httpURLConnection.doOutput = true
        httpURLConnection.connect()
        val bufferedReader =
            BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }

    fun parseJsonToData(jsonObject: JSONObject): List<User>? {
        val userList: MutableList<User> = ArrayList()
        try {
            val jsonArray = jsonObject.getJSONArray(UserEntry.USER)
            for (i in 0 until jsonArray.length()) {
                val userJson = jsonArray.getJSONObject(i)
                val user = parseJsonToObject(userJson)
                user?.let { userList.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return userList
    }

    private fun parseJsonToObject(jsonObjectUser: JSONObject): User? {
        var user: User? = null
        try {
            jsonObjectUser?.let {
                user = User(email = jsonObjectUser.getString(UserEntry.EMAIL),
                password = jsonObjectUser.getString(UserEntry.PASSWORD))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return user
    }
}
