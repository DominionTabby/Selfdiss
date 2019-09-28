package com.gmail.tabiszdominik.selfdiss.repositories

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class InsultsRepository(private val insults: List<String>, private val vulgarInsults: List<String>) {

    fun getRandomInsult(previousInsult: String = ""): String {
        //TODO add checking for vulgar insults setting
        return (insults + vulgarInsults).shuffled().first { it != previousInsult }
    }
}