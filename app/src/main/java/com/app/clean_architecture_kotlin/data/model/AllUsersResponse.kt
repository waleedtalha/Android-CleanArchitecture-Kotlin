package com.app.clean_architecture_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class AllUsersResponse(
    @SerializedName("users")
    var users: ArrayList<User> = arrayListOf(),
    @SerializedName("total")
    var total: Int? = null,
    @SerializedName("skip")
    var skip: Int? = null,
    @SerializedName("limit")
    var limit: Int? = null
)