package com.app.clean_architecture_kotlin.data.repository

import com.app.clean_architecture_kotlin.data.model.LoginResponse
import com.app.clean_architecture_kotlin.data.network.RemoteDataSource
import com.app.clean_architecture_kotlin.data.network.Resource
import com.app.clean_architecture_kotlin.domain.repository.LoginRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * Repository class for fetching data[LoginResponse] from server
 * */
class LoginRepositoryImpl(private val remoteDataSource: RemoteDataSource) : LoginRepository {

    override suspend fun loginUser(username: String, password: String): Flow<Resource<LoginResponse>> {
        val gson = Gson()
        val requestBodyJson = gson.toJson(
            mapOf(
                "username" to username,
                "password" to password,
                "expiresInMins" to 60,
            )
        )
        val requestBody = requestBodyJson.toRequestBody("application/json".toMediaTypeOrNull())
        return flow {
            emit(Resource.loading(null))
            val response = remoteDataSource.loginUser(requestBody)
            emit(response)
        }
    }

}