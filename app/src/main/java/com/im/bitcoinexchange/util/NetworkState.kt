package com.im.bitcoinexchange.util

import android.net.Network

sealed class NetworkState<T>(
    val data : T? = null,
    val error : String? = null
){

    class Success<T> (data: T) : NetworkState<T>(data)
    class Error<T> (error : String) : NetworkState<T>(error = error)
    class Loading<T> () : NetworkState<T>()

}