package com.mudassir.domain.entity


import com.squareup.moshi.Json

data class DataEntity(
    @Json(name = "cities")
    val cities: List<City>,
    @Json(name = "foods")
    val foods: List<Food>
)

