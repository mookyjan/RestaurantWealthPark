package com.mudassir.domain.usecase

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.SingleUseCase
import com.mudassir.domain.entity.DataEntity
import com.mudassir.domain.gateway.WealthParkDataGateWay
import io.reactivex.rxjava3.core.Single

class RestaurantUseCase(
    schedulers: SchedulerProvider,
    private val wealthParkDataGateWay: WealthParkDataGateWay
) : SingleUseCase<Boolean, DataEntity>(schedulers) {


    override fun buildUseCaseObservable(isRefresh: Boolean?): Single<DataEntity> {

        return wealthParkDataGateWay.getRestaurantData(isRefresh)
    }
}