package com.mudassir.data.gateway

import com.mudassir.data.repository.WealthParkDataRepository
import com.mudassir.domain.entity.DataEntity
import com.mudassir.domain.gateway.WealthParkDataGateWay
import io.reactivex.rxjava3.core.Single

class WealthParkDataGateWayImpl constructor(private val wealthParkDataRepository: WealthParkDataRepository) :
    WealthParkDataGateWay {

//    override fun getCategoryList(isRefresh:Boolean?): Single<List<CategoryEntity>> {
//        val list: Single<List<CategoryEntity>> = categoryListRepository.getCategoryList(isRefresh).map {
//            it.mapToDomain()
//        }
//        return list
//    }

    override fun getRestaurantData(isRefresh: Boolean?): Single<DataEntity> {

        return wealthParkDataRepository.getRestaurantData(isRefresh)
    }
}