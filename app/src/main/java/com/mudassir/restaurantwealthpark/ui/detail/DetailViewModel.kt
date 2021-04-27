package com.mudassir.restaurantwealthpark.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mudassir.domain.entity.City

class DetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val cityModel : MutableLiveData<City> = MutableLiveData()
}