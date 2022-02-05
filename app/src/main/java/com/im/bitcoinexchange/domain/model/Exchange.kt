package com.im.bitcoinexchange.domain.model

import java.io.Serializable

data class Exchange(

    val chartName: String,
    val disclaimer: String,

    val updated: String,
    val updatedISO: String,
    val updateduk: String,

    val gbpCode: String,
    val gbpDescription: String,
    val gbpRate: String,
    val gbpRate_float: Double,
    val gbpSymbol: String,

    val usdCode: String,
    val usdDescription: String,
    val usdRate: String,
    val usdRate_float: Double,
    val usdSymbol: String,

    val eurCode: String,
    val eurDescription: String,
    val eurRate: String,
    val eurRate_float: Double,
    val eurSymbol: String,


    ) : Serializable
