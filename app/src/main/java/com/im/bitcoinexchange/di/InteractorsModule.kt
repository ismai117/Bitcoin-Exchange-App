package com.im.bitcoinexchange.di

import com.im.bitcoinexchange.network.util.ExchangeNetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {


    @Singleton
    @Provides
    fun provideExchangeNetworkMapper(): ExchangeNetworkMapper {
        return ExchangeNetworkMapper()
    }

}