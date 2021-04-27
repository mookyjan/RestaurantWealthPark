package com.mudassir.data.remote.models

import com.mudassir.domain.entity.DataEntity
import com.squareup.moshi.Json

class ApiResponse(
    @Json(name = "cities")
    val cities: List<CityModel>,
    @Json(name = "foods")
    val foods: List<FoodModel>
)

data class CityModel(
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String
)

data class FoodModel(
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String
)


//fun ApiResponse.mapToDomain(): DataEntity =
//    DataEntity(name=name!!,data=data!!)
