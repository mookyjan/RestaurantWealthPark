package com.mudassir.data.remote.api

import com.mudassir.data.remote.models.ApiResponse
import com.mudassir.domain.entity.DataEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface WealthParkService {

    @GET("a2b63ef226c08553b2f9")
    fun getData(): Single<DataEntity>
}