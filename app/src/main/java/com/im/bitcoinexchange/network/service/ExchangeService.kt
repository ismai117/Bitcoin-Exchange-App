package com.im.bitcoinexchange.network.service

import com.im.bitcoinexchange.network.exchange.ExchangeNetworkEntity
import retrofit2.http.GET

interface ExchangeService {

    @GET("v1/bpi/currentprice.json")
    suspend fun getExchange(): ExchangeNetworkEntity

}