package com.app.clean_architecture_kotlin.domain.repository

import com.app.clean_architecture_kotlin.data.model.AllUsersResponse
import com.app.clean_architecture_kotlin.data.network.Resource
import kotlinx.coroutines.flow.Flow

/**
 * interface to make an interaction between [AllUserRepositoryImpl] & [AllUserUseCase]
 * */
interface AllUserRepository {
    suspend fun allUsers(): Flow<Resource<AllUsersResponse>>
}