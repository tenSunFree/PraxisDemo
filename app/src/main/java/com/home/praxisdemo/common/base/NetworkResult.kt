package com.home.praxisdemo.common.base

sealed class NetworkResult<out T> {

  data class Success<T>(val body: T) : NetworkResult<T>()

  data class Failure<T>(val message:String) : NetworkResult<T>()
}