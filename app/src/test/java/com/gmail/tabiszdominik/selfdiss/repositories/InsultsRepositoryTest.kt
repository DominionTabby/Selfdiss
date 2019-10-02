package com.gmail.tabiszdominik.selfdiss.repositories

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

/**
 * Created by Dominik Tabisz on 2019-09-29.
 * tabiszdominik@gmail.com
 */
class InsultsRepositoryTest {

    companion object {
        private val INSULTS = listOf("insult1", "insult2")
        private val VULGAR_INSULTS = listOf("vulgarInsult1", "vulgarInsult2")
    }

    private lateinit var repository: InsultsRepository

    @Mock
    private lateinit var preferencesRepositoryMock: PreferencesRepository

    @Before
    fun before() {
        initMocks(this)
        repository = InsultsRepository(
            insults = INSULTS,
            preferencesRepository = preferencesRepositoryMock,
            vulgarInsults = VULGAR_INSULTS
        )
    }

    @Test
    fun testGetRandomInsult() {
        whenever(preferencesRepositoryMock.useVulgarInsults).thenReturn(true)

        var previousInsult: String
        var insult = repository.getRandomInsult()
        assertTrue((INSULTS + VULGAR_INSULTS).any { it == insult })

        previousInsult = insult
        insult = repository.getRandomInsult(previousInsult)
        assertTrue((INSULTS + VULGAR_INSULTS).any { it != previousInsult } && insult != previousInsult)

        whenever(preferencesRepositoryMock.useVulgarInsults).thenReturn(false)

        previousInsult = insult
        insult = repository.getRandomInsult(previousInsult)
        assertTrue((INSULTS).any { it != previousInsult } && insult != previousInsult)
    }
}