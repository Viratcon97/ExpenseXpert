package com.expensexpert.data

import com.expensexpert.data.module.WeatherModule
import com.expensexpert.view.MainActivity
import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class])
interface WeatherSubComponent {
    fun inject(mainActivity: MainActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create():WeatherSubComponent
    }
}