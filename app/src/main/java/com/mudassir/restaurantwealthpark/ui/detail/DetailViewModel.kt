package com.mudassir.restaurantwealthpark.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mudassir.domain.entity.City
import javax.inject.Inject

class DetailViewModel @Inject constructor() : ViewModel() {

    val cityModel : MutableLiveData<City> = MutableLiveData()
}