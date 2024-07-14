package com.app.clean_architecture_kotlin.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("maidenName") var maidenName: String? = null,
    @SerializedName("age") var age: Int? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("birthDate") var birthDate: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("bloodGroup") var bloodGroup: String? = null,
    @SerializedName("height") var height: Double? = null,
    @SerializedName("weight") var weight: Double? = null,
    @SerializedName("eyeColor") var eyeColor: String? = null,
    @SerializedName("hair") var hair: JsonObject? = null,
    @SerializedName("ip") var ip: String? = null,
    @SerializedName("address") var address: JsonObject? = null,
    @SerializedName("macAddress") var macAddress: String? = null,
    @SerializedName("university") var university: String? = null,
    @SerializedName("bank") var bank: JsonObject? = null,
    @SerializedName("company") var company: JsonObject? = null,
    @SerializedName("ein") var ein: String? = null,
    @SerializedName("ssn") var ssn: String? = null,
    @SerializedName("userAgent") var userAgent: String? = null,
    @SerializedName("crypto") var crypto: JsonObject? = null,
    @SerializedName("role") var role: String? = null
)
