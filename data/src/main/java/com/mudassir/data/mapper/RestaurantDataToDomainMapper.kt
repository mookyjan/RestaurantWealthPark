package com.mudassir.data.mapper

import com.mudassir.data.remote.models.ApiResponse
import com.mudassir.domain.entity.DataEntity

//object RestaurantDataToDomainMapper : BaseMapper<DataEntity,ApiResponse> (){
//
//    override fun transformFrom(source: ApiResponse): DataEntity {
//        return DataEntity(cities = source.cities,foods = source.foods)
//    }
//
//    override fun transformTo(source: DataEntity): ApiResponse {
//        return ApiResponse(cities = source.cities,foods = source.copy(source.foods))
//    }
//}