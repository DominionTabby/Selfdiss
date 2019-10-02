package com.gmail.tabiszdominik.selfdiss

import com.gmail.tabiszdominik.selfdiss.base.BaseViewModelTest
import io.reactivex.observers.TestObserver
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Dominik Tabisz on 2019-09-29.
 * tabiszdominik@gmail.com
 */
class MainViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: MainViewModel

    private lateinit var navigationCommandObserver: TestObserver<NavigationCommand>

    override fun createViewModel() {
        viewModel = MainViewModel()
        navigationCommandObserver = viewModel.navigationCommand.test()
    }

    @Test
    fun testInitialState() {
        navigationCommandObserver.assertNoValues()
    }

    @Test
    fun testOpenSettings() {
        viewModel.openSettings()
        assertEquals(navigationCommandObserver.values().last(), NavigationCommand.OpenSettings)
    }
}