package com.app.clean_architecture_kotlin.data.repository

import com.app.clean_architecture_kotlin.data.model.AllUsersResponse
import com.app.clean_architecture_kotlin.data.network.RemoteDataSource
import com.app.clean_architecture_kotlin.data.network.Resource
import com.app.clean_architecture_kotlin.domain.repository.AllUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Repository class for fetching data[AllUsersResponse] from server
 * */
class AllUserRepositoryImpl(private val remoteDataSource: RemoteDataSource) : AllUserRepository {

    override suspend fun allUsers(): Flow<Resource<AllUsersResponse>> {
        return flow {
            emit(Resource.loading(null))
            val response = remoteDataSource.getAllUsers()
            emit(response)
        }
    }

}