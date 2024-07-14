package com.app.clean_architecture_kotlin.data.network

import com.app.clean_architecture_kotlin.data.model.LoginResponse
import com.app.clean_architecture_kotlin.data.model.AllUsersResponse
import com.app.clean_architecture_kotlin.utils.extension.*
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST(LOGIN_EP)
    suspend fun loginUser(@Body request: RequestBody): Response<LoginResponse>

    @GET(All_USERS_EP)
    suspend fun getAllUsers(): Response<AllUsersResponse>
}