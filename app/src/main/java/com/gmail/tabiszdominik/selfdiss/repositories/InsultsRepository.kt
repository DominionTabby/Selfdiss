package com.gmail.tabiszdominik.selfdiss.repositories

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class InsultsRepository(
    private val insults: List<String>,
    private val preferencesRepository: PreferencesRepository,
    private val vulgarInsults: List<String>
) {

    fun getRandomInsult(previousInsult: String = ""): String {
        return if (preferencesRepository.useVulgarInsults) {
            insults + vulgarInsults
        } else {
            insults
        }.shuffled().first { it != previousInsult }
    }
}