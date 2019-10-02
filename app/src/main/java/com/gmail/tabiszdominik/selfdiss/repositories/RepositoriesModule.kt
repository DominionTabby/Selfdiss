package com.gmail.tabiszdominik.selfdiss.repositories

import android.content.ContextWrapper
import com.gmail.tabiszdominik.selfdiss.R
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
val repositoriesModule = module {
    single {
        androidContext().getSharedPreferences(
            androidContext().packageName + "_preferences",
            ContextWrapper.MODE_PRIVATE
        )
    }
    single {
        InsultsRepository(
            insults = androidContext().resources.getStringArray(R.array.insults).asList(),
            preferencesRepository = get(),
            vulgarInsults = androidContext().resources.getStringArray(R.array.insults_vulgar).asList()
        )
    }
    single {
        PreferencesRepository(preferences = get())
    }
}