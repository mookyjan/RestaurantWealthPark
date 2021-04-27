package com.mudassir.restaurantwealthpark.di.module

import android.app.Application
import android.content.Context
import com.mudassir.domain.SchedulerProvider
import com.mudassir.restaurantwealthpark.di.module.scheduler.AppSchedulers
import com.mudassir.restaurantwealthpark.navigation.NavManager
import com.mudassir.restaurantwealthpark.util.IResourceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    @Named("application.Context")
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideSchedulers() : SchedulerProvider = AppSchedulers()

    @Provides
    @Singleton
    fun provideResource(context: Context) = IResourceProvider(context)

    @Provides
    @Singleton
    internal fun provideNavManager() : NavManager = NavManager()
}