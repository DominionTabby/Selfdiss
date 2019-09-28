package com.gmail.tabiszdominik.selfdiss.fragments.insult

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
val insultModule = module {
    viewModel {
        InsultViewModel(
            insultsRepository = get()
        )
    }
}