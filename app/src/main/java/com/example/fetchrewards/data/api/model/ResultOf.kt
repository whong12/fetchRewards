package com.example.fetchrewards.data.api.model

sealed class ResultOf<out T> {
    data class Success<out R>(
        val value: R
    ): ResultOf<R>()

    data class Error(
        val message: String?,
        val throwable: Throwable?
    ): ResultOf<Nothing>()
}