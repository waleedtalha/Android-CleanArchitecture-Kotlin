package com.app.clean_architecture_kotlin.utils.helper

import android.content.Context
import android.content.SharedPreferences
import com.app.clean_architecture_kotlin.utils.helper.PreferenceHelper.PreferenceVariable.AUTH_TOKEN

class PreferenceHelper(context: Context) {
    private val appPrefs: SharedPreferences =
        context.getSharedPreferences("app_pref", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = appPrefs.edit()

    object PreferenceVariable {
        const val AUTH_TOKEN = "auth_token"
    }

    init {
        editor.apply()
    }

    var authToken: String?
        get() = appPrefs.getString(AUTH_TOKEN, "")
        set(token) {
            editor.putString(AUTH_TOKEN, token)
            editor.apply()
        }

    fun clearPreference() {
        editor.clear()
        editor.apply()
    }
}