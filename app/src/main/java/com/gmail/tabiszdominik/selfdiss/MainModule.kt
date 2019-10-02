package com.gmail.tabiszdominik.selfdiss

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
val mainModule = module {
    viewModel { MainViewModel() }
}