package com.app.clean_architecture_kotlin.domain.repository

import com.app.clean_architecture_kotlin.data.model.LoginResponse
import com.app.clean_architecture_kotlin.data.network.Resource
import kotlinx.coroutines.flow.Flow

/**
 * interface to make an interaction between [LoginRepositoryImpl] & [LoginUseCase]
 * */
interface LoginRepository {
    suspend fun loginUser(username: String, password: String): Flow<Resource<LoginResponse>>
}