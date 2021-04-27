package com.mudassir.restaurantwealthpark.di.module

import android.content.Context
import com.mudassir.data.gateway.WealthParkDataGateWayImpl
import com.mudassir.data.local.WealthParkDatabase
import com.mudassir.data.local.WealthParkLocalDataSource
import com.mudassir.data.local.dao.WealthParkDao
import com.mudassir.data.remote.WealthParkRemoteDataSource
import com.mudassir.data.remote.api.WealthParkService
import com.mudassir.data.repository.WealthParkDataRepository
import com.mudassir.domain.gateway.WealthParkDataGateWay
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideRestaurantListRemoteDataSource(wealthParkService: WealthParkService)
            = WealthParkRemoteDataSource(wealthParkService)


    @Provides
    fun provideWealthParkRepository(localDataSource: WealthParkLocalDataSource,wealthParkRemoteDataSource: WealthParkRemoteDataSource)
            = WealthParkDataRepository(localDataSource,wealthParkRemoteDataSource)

    @Provides
    fun provideWealthParkGateWay(wealthParkDataRepository: WealthParkDataRepository): WealthParkDataGateWay
            = WealthParkDataGateWayImpl(wealthParkDataRepository)



    /**
     * wealthPark database
     */
    @Provides
    fun provideWealthParkDatabase(context: Context) = WealthParkDatabase.newInstance(context)

    @Provides
    @Singleton
    internal fun provideWealthParkDao(wealthParkDatabase: WealthParkDatabase) =
        wealthParkDatabase.wealthParkDao()

    @Provides
    @Singleton
    internal fun provideWealthParkLocalDataSource(wealthParkDao: WealthParkDao) =
        WealthParkLocalDataSource(wealthParkDao)

}