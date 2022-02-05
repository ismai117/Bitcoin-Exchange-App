package com.im.bitcoinexchange.network.util

import com.im.bitcoinexchange.network.exchange.ExchangeNetworkEntity
import com.im.bitcoinexchange.domain.model.Exchange
import com.im.bitcoinexchange.domain.util.EntityMapper

class ExchangeNetworkMapper : EntityMapper<ExchangeNetworkEntity, Exchange>{

    override fun mapTo(entity: ExchangeNetworkEntity): Exchange {

        return Exchange(
            chartName = entity.chartName,
            disclaimer = entity.disclaimer,
            updated = entity.time.updated,
            updatedISO = entity.time.updatedISO,
            updateduk = entity.time.updateduk,
            gbpCode = entity.bpi.GBP.gbpCode,
            gbpDescription = entity.bpi.GBP.gbpDescription,
            gbpRate =entity.bpi.GBP.gbpRate ,
            gbpRate_float = entity.bpi.GBP.gbpRate_float,
            gbpSymbol = entity.bpi.GBP.gbpSymbol,
            usdCode = entity.bpi.USD.usdCode,
            usdDescription = entity.bpi.USD.usdDescription,
            usdRate = entity.bpi.USD.usdRate,
            usdRate_float = entity.bpi.USD.usdRate_float,
            usdSymbol = entity.bpi.USD.usdSymbol,
            eurCode = entity.bpi.EUR.eurCode,
            eurDescription = entity.bpi.EUR.eurDescription,
            eurRate = entity.bpi.EUR.eurRate,
            eurRate_float = entity.bpi.EUR.eurRate_float,
            eurSymbol = entity.bpi.EUR.eurSymbol,
        )

    }

    override fun mapFrom(model: Exchange): ExchangeNetworkEntity {
        TODO("Not yet implemented")
    }

    fun mapFromEntityList(entityList: List<ExchangeNetworkEntity>): List<Exchange> {
        return entityList.map { mapTo(it) }
    }

}