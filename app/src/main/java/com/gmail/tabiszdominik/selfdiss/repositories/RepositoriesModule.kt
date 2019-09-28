package com.gmail.tabiszdominik.selfdiss.repositories

import com.gmail.tabiszdominik.selfdiss.R
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
val repositoriesModule = module {
    single {
        InsultsRepository(
            insults = androidContext().resources.getStringArray(R.array.insults).asList(),
            vulgarInsults = androidContext().resources.getStringArray(R.array.insults_vulgar).asList()
        )
    }
}