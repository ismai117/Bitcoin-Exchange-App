package com.im.bitcoinexchange.repository

import com.im.bitcoinexchange.domain.model.Exchange
import com.im.bitcoinexchange.network.service.ExchangeService
import com.im.bitcoinexchange.network.util.ExchangeNetworkMapper
import javax.inject.Inject

class Repository
@Inject
constructor(
    private val exchangeService: ExchangeService,
    private val exchangeNetworkMapper: ExchangeNetworkMapper
) {

    suspend fun Exchanges(): List<Exchange> = exchangeNetworkMapper.mapFromEntityList(
        listOf(exchangeService.getExchange())
    )

}