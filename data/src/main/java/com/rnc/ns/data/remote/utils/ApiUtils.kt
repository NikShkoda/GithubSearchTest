package com.rnc.ns.data.remote.utils

import com.rnc.ns.domain.model.remote.Result
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T> apiCall(call: suspend () -> Response<T>): Result<T> {
    try {
        val response = call.invoke()
        if (response.isSuccessful) {
            if (response.body() != null) {
                return Result.success(response.body())
            }
        }
        return Result.error(response.message())
    } catch (e: Exception) {
        return when (e) {
            is ConnectException -> {
                Result.error(CONNECT_EXCEPTION)
            }
            is UnknownHostException -> {
                Result.error(UNKNOWN_HOST_EXCEPTION)
            }
            is SocketTimeoutException -> {
                Result.error(SOCKET_TIME_OUT_EXCEPTION)
            }
            is HttpException -> {
                Result.error(UNKNOWN_NETWORK_EXCEPTION)
            }
            else -> {
                Result.error(UNKNOWN_NETWORK_EXCEPTION)
            }
        }
    }
}

private const val SOCKET_TIME_OUT_EXCEPTION =
    "Request timed out while trying to connect. Please ensure you have a strong signal and try again."
private const val UNKNOWN_NETWORK_EXCEPTION =
    "An unexpected error has occurred. Please check your network connection and try again."
private const val CONNECT_EXCEPTION =
    "Could not connect to the server. Please check your internet connection and try again."
private const val UNKNOWN_HOST_EXCEPTION =
    "Couldn't connect to the server at the moment. Please try again in a few minutes."