package com.gmail.tabiszdominik.selfdiss

import android.app.Application
import com.gmail.tabiszdominik.selfdiss.fragments.insult.insultModule
import com.gmail.tabiszdominik.selfdiss.fragments.settings.settingsModule
import com.gmail.tabiszdominik.selfdiss.repositories.repositoriesModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin(
            androidContext = this@App,
            modules = listOf(
                repositoriesModule,
                mainModule,
                insultModule,
                settingsModule
            )
        )
    }
}