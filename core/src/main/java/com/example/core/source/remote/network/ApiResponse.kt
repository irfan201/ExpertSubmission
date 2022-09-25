package com.example.core.source.remote.network

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    object Empty : ApiResponse<Nothing>()
    data class Error(val message: String) : ApiResponse<Nothing>()
}
