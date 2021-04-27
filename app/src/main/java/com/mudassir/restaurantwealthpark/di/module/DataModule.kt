package com.mudassir.restaurantwealthpark.di.module

import com.mudassir.data.gateway.WealthParkDataGateWayImpl
import com.mudassir.data.remote.WealthParkRemoteDataSource
import com.mudassir.data.remote.api.WealthParkService
import com.mudassir.data.repository.WealthParkDataRepository
import com.mudassir.domain.gateway.WealthParkDataGateWay
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRestaurantListRemoteDataSource(wealthParkService: WealthParkService)
            = WealthParkRemoteDataSource(wealthParkService)


    @Provides
    fun provideWealthParkRepository(wealthParkRemoteDataSource: WealthParkRemoteDataSource)
            = WealthParkDataRepository(wealthParkRemoteDataSource)

    @Provides
    fun provideWealthParkGateWay(wealthParkDataRepository: WealthParkDataRepository): WealthParkDataGateWay
            = WealthParkDataGateWayImpl(wealthParkDataRepository)

}