package com.mudassir.restaurantwealthpark.di.module

import com.mudassir.restaurantwealthpark.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}