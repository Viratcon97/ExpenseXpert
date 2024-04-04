package com.expensexpert.data.module

import android.content.Context
import com.expensexpert.data.WeatherSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    WeatherSubComponent::class]
)
class AppModule(private val context: Context)  {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}