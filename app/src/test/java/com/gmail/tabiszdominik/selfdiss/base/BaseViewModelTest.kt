package com.gmail.tabiszdominik.selfdiss.base

import org.junit.Before
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Dominik Tabisz on 2019-09-29.
 * tabiszdominik@gmail.com
 */
abstract class BaseViewModelTest {

    abstract fun createViewModel()

    @Before
    fun before() {
        initMocks(this)
        createViewModel()
    }
}