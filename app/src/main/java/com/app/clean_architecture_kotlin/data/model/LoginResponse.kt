package com.app.clean_architecture_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("firstName")
    var firstName: String? = null,
    @SerializedName("lastName")
    var lastName: String? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("refreshToken")
    var refreshToken: String? = null
)