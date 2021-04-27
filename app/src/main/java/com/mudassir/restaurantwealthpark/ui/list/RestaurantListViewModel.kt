package com.mudassir.restaurantwealthpark.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.Timber
import com.mudassir.domain.entity.City
import com.mudassir.domain.entity.DataEntity
import com.mudassir.domain.usecase.RestaurantUseCase
import com.mudassir.restaurantwealthpark.base.BaseViewModel
import com.mudassir.restaurantwealthpark.navigation.NavManager
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class RestaurantListViewModel @Inject constructor(
    private val wealthParkUseCase: RestaurantUseCase,
    private val navManager: NavManager
) : BaseViewModel() {

    private val _cityList = MutableLiveData<DataEntity>()
    var cityList: LiveData<DataEntity> = _cityList

    init {
        getRestaurantList()
    }

    fun getRestaurantList(isRefresh: Boolean = true) {
        _loading.postValue(true)
        val result = wealthParkUseCase.execute(isRefresh)
        result.subscribeBy(onSuccess = {
            _loading.postValue(false)
            _cityList.postValue(it)
            Timber.d { "city list api response $it" }
        }, onError = { e ->
            _loading.postValue(false)
            _error.postValue(e.localizedMessage ?: e.message ?: "Unknown error")
            Timber.e { "error on restaurant list api ${e.printStackTrace()}" }
        }).addTo(compositeDisposable)

    }

    fun refresh() = getRestaurantList(true)

    fun navigateToDetail(city: City) {
        val navDirections =
            RestaurantListFragmentDirections.actionRestaurantListFragmentToDetailFragment(city)
        navManager.navigate(navDirections)
    }
}