package com.expensexpert

import android.app.Application
import com.expensexpert.data.AppComponent
import com.expensexpert.data.module.AppModule
import com.expensexpert.data.DaggerAppComponent
import com.expensexpert.data.module.DataModule
import com.expensexpert.data.Injector
import com.expensexpert.data.module.NetModule
import com.expensexpert.data.WeatherSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule())
            .dataModule(DataModule("Waterloo"))
            .build()
    }

    override fun createWeatherSubComponent(): WeatherSubComponent {
        return appComponent.weatherSubComponent().create()
    }
}