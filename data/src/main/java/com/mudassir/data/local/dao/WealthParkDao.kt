package com.mudassir.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mudassir.data.local.models.CityLocalEntity
import com.mudassir.data.local.models.DataEntityLocal
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single


@Dao
interface WealthParkDao {

    @Query("SELECT * FROM data_table")
    fun getData(): Maybe<DataEntityLocal>

//    @Query("SELECT * FROM city_table WHERE name =:name")
//    fun getCity(name:String) : Single<CityLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: DataEntityLocal)

    @Query("DELETE FROM data_table")
    fun deleteAllData()
}