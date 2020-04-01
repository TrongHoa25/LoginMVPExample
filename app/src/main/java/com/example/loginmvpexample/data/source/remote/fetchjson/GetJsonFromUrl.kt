package com.example.loginmvpexample.data.source.remote.fetchjson

import android.os.AsyncTask
import com.example.loginmvpexample.data.model.User
import com.example.loginmvpexample.data.source.remote.OnFetchDataJsonListener
import org.json.JSONException
import org.json.JSONObject

class GetJsonFromUrl constructor(
    private val mListener: OnFetchDataJsonListener<User>?
) : AsyncTask<String, Void, String>() {
    private val LOG = GetDataJson::class.java.simpleName

    override fun doInBackground(vararg strings: String?): String? {
        var data = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            data = parseDataWithJson.getJsonFromUrl(strings[0])!!
        } catch (e: Exception) {
            mListener!!.onError(e)
        }
        return data
    }

    override fun onPostExecute(data: String?) {
        super.onPostExecute(data)
        if (data != null) {
            try {
                val jsonObject = JSONObject(data)
                mListener!!.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject))
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }
}