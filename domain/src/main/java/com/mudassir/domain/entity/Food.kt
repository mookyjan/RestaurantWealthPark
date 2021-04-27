package com.mudassir.domain.entity


import com.squareup.moshi.Json

data class Food(
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String
)