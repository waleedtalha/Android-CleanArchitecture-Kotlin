package com.app.clean_architecture_kotlin.data.network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response

abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            val body = response.body()
            if (response.isSuccessful) {
                if (body != null) return Resource.success(body)
            } else {
                val gson = Gson()
                val type = object : TypeToken<ErrorResponse>() {}.type
                val errorResponse: ErrorResponse? =
                    gson.fromJson(response.errorBody()!!.charStream(), type)
                return Resource.error(errorResponse?.message, body, response.code())
            }
        } catch (e: Exception) {
            Log.wtf("base data source get result function", e.toString())
            return Resource.error(e.message ?: e.toString(), null, 429)
        }
        return Resource.error(null, null, 429)
    }
}