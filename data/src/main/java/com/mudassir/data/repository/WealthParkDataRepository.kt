package com.mudassir.data.repository

import com.mudassir.data.remote.WealthParkRemoteDataSource
import com.mudassir.data.remote.models.ApiResponse
import com.mudassir.domain.entity.DataEntity
import io.reactivex.rxjava3.core.Single


class WealthParkDataRepository constructor(
  private val wealthParkRemoteDataSource: WealthParkRemoteDataSource
) {

    fun getRestaurantData(refresh: Boolean? = false): Single<DataEntity> {

        return wealthParkRemoteDataSource.getRestaurantData()

//        val local = categoryListLocalDataSource.getCategoryList().filter {
//            it.isNotEmpty()
//        }.toSingle()
//
//        val remote = wealthParkRemoteDataSource.getRestaurantData().map {
//            it.mapToLocal()
//        }.doOnSuccess {
//            categoryListLocalDataSource.insertCategoryList(it)
//        }
//        return Single.just(refresh)
//            .flatMap {
//                if (it)
//                    categoryListLocalDataSource.deleteAllCategoryData()
//                Single.concat(local.onErrorResumeNext(remote), remote)
//                    .firstElement().toSingle()
//            }
    }

}