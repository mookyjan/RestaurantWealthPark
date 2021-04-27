package com.mudassir.restaurantwealthpark.di.module

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.gateway.WealthParkDataGateWay
import com.mudassir.domain.usecase.RestaurantUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideRestaurantListUseCase(schedulerProvider: SchedulerProvider, restaurantGateWay: WealthParkDataGateWay)
            = RestaurantUseCase(schedulerProvider,restaurantGateWay)
}