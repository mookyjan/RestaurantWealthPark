package com.mudassir.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mudassir.domain.entity.City
import com.mudassir.domain.entity.DataEntity
import com.mudassir.domain.entity.Food

@Entity(tableName = "data_table")
data class DataEntityLocal (
    @PrimaryKey (autoGenerate = true)
    var id: Int?,
    @ColumnInfo(name = "cities")
    val cities: List<CityLocalEntity>,
    @ColumnInfo(name = "foods")
    val foods: List<FoodLocalEntity>
)

@Entity(tableName = "city_table")
data class CityLocalEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "image")
    val image: String,
)

@Entity(tableName = "food_table")
data class FoodLocalEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image")
    val image: String
)


fun DataEntity.mapToLocal(): DataEntityLocal =
    DataEntityLocal(id = 1,cities =cities.mapToCityLocal() ,foods = foods.mapToLocal())

//fun List<CategoryListResponse>.mapToLocal(): List<CategoryListLocalEntity> = map { it.mapToLocal() }


fun Food.mapToLocal(): FoodLocalEntity =
    FoodLocalEntity(name = name,image = image)

fun List<Food>.mapToLocal(): List<FoodLocalEntity> = map { it.mapToLocal() }

fun City.mapToLocal(): CityLocalEntity =
    CityLocalEntity(name = name, description= description,image=image)

fun List<City>.mapToCityLocal(): List<CityLocalEntity> = map { it.mapToLocal() }



fun DataEntityLocal.mapToDomain(): DataEntity =
    DataEntity(cities =cities.mapToCityDomain() ,foods = foods.mapToDomain())

//fun List<CategoryListResponse>.mapToLocal(): List<CategoryListLocalEntity> = map { it.mapToLocal() }


fun FoodLocalEntity.mapToDomain(): Food =
    Food(name = name,image = image)

fun List<FoodLocalEntity>.mapToDomain(): List<Food> = map { it.mapToDomain() }

fun CityLocalEntity.mapToDomain(): City =
    City(name = name, description= description,image=image)

fun List<CityLocalEntity>.mapToCityDomain(): List<City> = map { it.mapToDomain() }