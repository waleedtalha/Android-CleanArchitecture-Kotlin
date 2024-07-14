package com.app.clean_architecture_kotlin.domain.usecase

import com.app.clean_architecture_kotlin.data.model.AllUsersResponse
import com.app.clean_architecture_kotlin.data.network.Resource
import com.app.clean_architecture_kotlin.domain.repository.AllUserRepository
import com.app.clean_architecture_kotlin.presentation.viewmodel.AllUserViewModel
import kotlinx.coroutines.flow.Flow

/**
 * An interactor class that executes the implementation of [AllUserViewModel]
 * It handles data responses and manages a list of users.
 */

class AllUserUseCase(private val allUserRepository: AllUserRepository) {
    suspend operator fun invoke(): Flow<Resource<AllUsersResponse>> {
        return allUserRepository.allUsers()
    }
}