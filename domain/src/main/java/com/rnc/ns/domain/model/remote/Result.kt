package com.rnc.ns.domain.model.remote

data class Result<out T>(val status: Status, val data: T?, val errorMessage: String?) {

    enum class Status {
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String): Result<T> {
            return Result(Status.ERROR, null, message)
        }
    }
}