package com.mudassir.restaurantwealthpark.di.module

import com.mudassir.restaurantwealthpark.ui.detail.DetailFragment
import com.mudassir.restaurantwealthpark.ui.list.RestaurantListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun restaurantListFragment() : RestaurantListFragment

    @ContributesAndroidInjector
    abstract fun restaurantDetailFragment(): DetailFragment
}