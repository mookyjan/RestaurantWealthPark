package com.mudassir.data.remote

import com.mudassir.data.remote.api.WealthParkService
import com.mudassir.data.remote.models.ApiResponse
import com.mudassir.domain.entity.DataEntity
import io.reactivex.rxjava3.core.Single

class WealthParkRemoteDataSource (private val wealthParkService: WealthParkService) {

    fun getRestaurantData() : Single<DataEntity> = wealthParkService.getData()

}