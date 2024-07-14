package com.app.clean_architecture_kotlin.data.network

data class ErrorResponse(
    val message: String,
    val success: Boolean
)