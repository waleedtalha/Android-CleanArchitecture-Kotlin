package com.app.clean_architecture_kotlin.data.network

import okhttp3.RequestBody

class RemoteDataSource(
    private val apiService: ApiService
) : BaseDataSource() {

    suspend fun loginUser(
        request: RequestBody
    ) = getResult {
        apiService.loginUser(
            request = request
        )
    }

    suspend fun getAllUsers() = getResult { apiService.getAllUsers() }

}