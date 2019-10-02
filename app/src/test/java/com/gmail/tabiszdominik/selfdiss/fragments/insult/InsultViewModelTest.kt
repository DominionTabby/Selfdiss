package com.gmail.tabiszdominik.selfdiss.fragments.insult

import com.gmail.tabiszdominik.selfdiss.base.BaseViewModelTest
import com.gmail.tabiszdominik.selfdiss.repositories.InsultsRepository
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
class InsultViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: InsultViewModel

    @Mock
    private lateinit var insultsRepositoryMock: InsultsRepository

    private lateinit var insultObserver: TestObserver<String>

    override fun createViewModel() {
        viewModel = InsultViewModel(insultsRepository = insultsRepositoryMock)
        insultObserver = viewModel.insult.test()
    }

    @Test
    fun testInitialState() {
        insultObserver.assertNoValues()
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
}