package com.app.clean_architecture_kotlin.app

import android.app.Application
import com.app.clean_architecture_kotlin.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(myModule)
        }
    }

}