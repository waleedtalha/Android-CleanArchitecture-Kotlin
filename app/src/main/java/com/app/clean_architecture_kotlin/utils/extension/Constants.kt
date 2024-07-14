package com.app.clean_architecture_kotlin.utils.extension

import android.os.Looper

const val BASE_URL = "https://dummyjson.com/"
const val LOGIN_EP = "auth/login"
const val All_USERS_EP = "users"

fun isOnMainThread() = Looper.myLooper() == Looper.getMainLooper()