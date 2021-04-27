package com.mudassir.restaurantwealthpark.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mudassir.restaurantwealthpark.ui.detail.DetailViewModel
import com.mudassir.restaurantwealthpark.ui.list.RestaurantListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantListViewModel::class)
    abstract fun provideCityListViewModel(viewModel: RestaurantListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun provideDetailViewModel(viewModel: DetailViewModel): ViewModel
}