package com.mudassir.domain.gateway

import com.mudassir.domain.entity.DataEntity
import io.reactivex.rxjava3.core.Single

interface WealthParkDataGateWay {

    fun getRestaurantData(isRefresh:Boolean?) : Single<DataEntity>
}