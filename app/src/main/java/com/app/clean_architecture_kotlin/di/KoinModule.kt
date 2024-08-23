package com.app.clean_architecture_kotlin.di

import com.app.clean_architecture_kotlin.data.network.RemoteDataSource
import com.app.clean_architecture_kotlin.data.network.provideApi
import com.app.clean_architecture_kotlin.data.network.provideRetrofit
import com.app.clean_architecture_kotlin.data.repository.AllUserRepositoryImpl
import com.app.clean_architecture_kotlin.data.repository.LoginRepositoryImpl
import com.app.clean_architecture_kotlin.domain.repository.AllUserRepository
import com.app.clean_architecture_kotlin.domain.repository.LoginRepository
import com.app.clean_architecture_kotlin.domain.usecase.AllUserUseCase
import com.app.clean_architecture_kotlin.domain.usecase.LoginUseCase
import com.app.clean_architecture_kotlin.presentation.viewmodel.AllUserViewModel
import com.app.clean_architecture_kotlin.presentation.viewmodel.LoginViewModel
import com.app.clean_architecture_kotlin.utils.helper.PreferenceHelper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    // declaration of singleton instances
    single { provideRetrofit() }
    single { PreferenceHelper(get()) }

    factory { provideApi(get()) }
    factory { RemoteDataSource(get()) }

    // repositories
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single<AllUserRepository> { AllUserRepositoryImpl(get()) }

    // Use cases
    factory { LoginUseCase(get()) }
    factory { AllUserUseCase(get()) }

    // View models
    viewModel { LoginViewModel(get(), get()) }
    viewModel { AllUserViewModel(get(), get()) }
}