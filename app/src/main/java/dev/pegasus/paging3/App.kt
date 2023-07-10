package dev.pegasus.paging3

import android.app.Application
import dev.pegasus.paging3.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(KoinModules().list)
        }
    }
}