package com.im.bitcoinexchange.network.exchange

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExchangeNetworkEntity(

    @Json(name = "time")
    val time: Time,

    @Json(name = "bpi")
    val bpi: Bpi,

    @Json(name = "chartName")
    val chartName: String,

    @Json(name = "disclaimer")
    val disclaimer: String,

    ){

    @JsonClass(generateAdapter = true)
    data class Time(

        @Json(name = "updated")
        val updated: String,

        @Json(name = "updatedISO")
        val updatedISO: String,

        @Json(name = "updateduk")
        val updateduk: String

    )

    @JsonClass(generateAdapter = true)
    data class Bpi(

        @Json(name = "EUR")
        val EUR: EUR,

        @Json(name = "GBP")
        val GBP: GBP,

        @Json(name = "USD")
        val USD: USD

    )

    @JsonClass(generateAdapter = true)
    data class GBP(

        @Json(name = "code")
        val gbpCode: String,

        @Json(name = "description")
        val gbpDescription: String,

        @Json(name = "rate")
        val gbpRate: String,

        @Json(name = "rate_float")
        val gbpRate_float: Double,

        @Json(name =  "symbol")
        val gbpSymbol: String

    )

    @JsonClass(generateAdapter = true)
    data class USD(

        @Json(name = "code")
        val usdCode: String,

        @Json(name = "description")
        val usdDescription: String,

        @Json(name = "rate")
        val usdRate: String,

        @Json(name = "rate_float")
        val usdRate_float: Double,

        @Json(name =  "symbol")
        val usdSymbol: String

    )

    @JsonClass(generateAdapter = true)
    data class EUR(

        @Json(name = "code")
        val eurCode: String,

        @Json(name = "description")
        val eurDescription: String,

        @Json(name = "rate")
        val eurRate: String,

        @Json(name = "rate_float")
        val eurRate_float: Double,

        @Json(name =  "symbol")
        val eurSymbol: String

    )

}