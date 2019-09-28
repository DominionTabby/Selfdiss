package com.gmail.tabiszdominik.selfdiss.fragments.insult

import androidx.lifecycle.ViewModel
import com.gmail.tabiszdominik.selfdiss.repositories.InsultsRepository
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class InsultViewModel(private val insultsRepository: InsultsRepository) : ViewModel() {

    private val insultSubject: BehaviorSubject<String> = BehaviorSubject.create()
    val insult: Observable<String> = insultSubject.hide()

    fun onInsultMeClick() =
        insultSubject.onNext(insultsRepository.getRandomInsult(previousInsult = insultSubject.value ?: ""))
}