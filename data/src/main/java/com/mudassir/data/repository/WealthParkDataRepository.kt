package com.mudassir.data.repository

import com.mudassir.data.local.WealthParkLocalDataSource
import com.mudassir.data.local.models.DataEntityLocal
import com.mudassir.data.local.models.mapToLocal
import com.mudassir.data.remote.WealthParkRemoteDataSource
import com.mudassir.data.remote.models.ApiResponse
import com.mudassir.domain.entity.DataEntity
import io.reactivex.rxjava3.core.Single


class WealthParkDataRepository constructor(
    private val localDataSource: WealthParkLocalDataSource,
  private val wealthParkRemoteDataSource: WealthParkRemoteDataSource
) {

    fun getRestaurantData(refresh: Boolean? = false): Single<DataEntityLocal> {

//        return wealthParkRemoteDataSource.getRestaurantData()

        val local : Single<DataEntityLocal> = localDataSource.getData()

        val remote = wealthParkRemoteDataSource.getRestaurantData().map {
            it.mapToLocal()
        }.doOnSuccess {
            localDataSource.insertData(it)
        }
        return Single.just(refresh)
            .flatMap {
                if (it!!)
                    localDataSource.deleteAllData()

                Single.concat(local.onErrorResumeNext {
                    Single.just(it);
                    remote
                },remote).firstElement().toSingle()


            }

//        return wealthParkRemoteDataSource.getRestaurantData()
    }

}