package com.csm.gardenapp.domain.util

sealed class Result {
    data class Success<T>(val data: T) : Result()
    data class Error(val message: String) : Result()

    fun isSuccess() = this is Success<*>
}