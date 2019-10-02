package com.gmail.tabiszdominik.selfdiss.fragments.settings

import com.gmail.tabiszdominik.selfdiss.base.BaseViewModelTest
import com.gmail.tabiszdominik.selfdiss.repositories.InsultsRepository
import com.gmail.tabiszdominik.selfdiss.repositories.PreferencesRepository
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.observers.TestObserver
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock

/**
 * Created by Dominik Tabisz on 2019-09-29.
 * tabiszdominik@gmail.com
 */
class SettingsViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: SettingsViewModel

    @Mock
    private lateinit var insultsRepositoryMock: InsultsRepository

    @Mock
    private lateinit var preferencesRepositoryMock: PreferencesRepository

    private lateinit var insultObserver: TestObserver<String>
    private lateinit var useVulgarInsults: TestObserver<Boolean>

    override fun createViewModel() {
        viewModel = SettingsViewModel(
            insultsRepository = insultsRepositoryMock,
            preferencesRepository = preferencesRepositoryMock
        )
        insultObserver = viewModel.insult.test()
        useVulgarInsults = viewModel.useVulgarInsults.test()
    }

    @Test
    fun testInitialState() {
        insultObserver.assertNoValues()
        useVulgarInsults.assertValue(false)
    }

    @Test
    fun testOnInsultMeClick() {
        whenever(insultsRepositoryMock.getRandomInsult("")).thenReturn("test")
        whenever(insultsRepositoryMock.getRandomInsult("test")).thenReturn("test2")

        viewModel.onInsultMeClick()
        verify(insultsRepositoryMock).getRandomInsult("")
        assertEquals(insultObserver.values().last(), "test")

        viewModel.onInsultMeClick()
        verify(insultsRepositoryMock).getRandomInsult("test")
        assertEquals(insultObserver.values().last(), "test2")
    }

    @Test
    fun testOnVulgarInsultsClick() {
        viewModel.onVulgarInsultsClick(true)
        assertEquals(useVulgarInsults.values().last(), true)

        viewModel.onVulgarInsultsClick(false)
        assertEquals(useVulgarInsults.values().last(), false)
    }
}