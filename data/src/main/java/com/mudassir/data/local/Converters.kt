package com.mudassir.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mudassir.data.local.models.CityLocalEntity
import com.mudassir.data.local.models.FoodLocalEntity

class Converters {


    @TypeConverter
    fun fromCityList(cityLang: List<CityLocalEntity>?): String? {
        val type = object : TypeToken<List<CityLocalEntity>>() {}.type
        return Gson().toJson(cityLang, type)
    }

    @TypeConverter
    fun toCityList(cityLangString: String?): List<CityLocalEntity>? {
        val type = object : TypeToken<List<CityLocalEntity>>() {}.type
        return Gson().fromJson<List<CityLocalEntity>>(cityLangString, type)
    }

    @TypeConverter
    fun fromFoodList(foodLang: List<FoodLocalEntity>?): String? {
        val type = object : TypeToken<List<FoodLocalEntity>>() {}.type
        return Gson().toJson(foodLang, type)
    }

    @TypeConverter
    fun toFoodList(foodLangString: String?): List<FoodLocalEntity>? {
        val type = object : TypeToken<List<FoodLocalEntity>>() {}.type
        return Gson().fromJson<List<FoodLocalEntity>>(foodLangString, type)
    }
}