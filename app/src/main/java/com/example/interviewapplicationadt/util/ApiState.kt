package com.example.interviewapplicationadt.util

import java.lang.Exception

sealed class ApiState<out E> {
    data class Success<out T>(val data: T) : ApiState<T>()
    data class Error(val exception: Exception) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
}