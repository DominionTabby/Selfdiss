package com.gmail.tabiszdominik.selfdiss.fragments.settings

import androidx.lifecycle.ViewModel
import com.gmail.tabiszdominik.selfdiss.repositories.InsultsRepository
import com.gmail.tabiszdominik.selfdiss.repositories.PreferencesRepository
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class SettingsViewModel(
    private val insultsRepository: InsultsRepository,
    private val preferencesRepository: PreferencesRepository
) : ViewModel() {

    private val insultSubject: BehaviorSubject<String> = BehaviorSubject.create()
    val insult: Observable<String> = insultSubject.hide()

    private val useVulgarInsultsSubject: BehaviorSubject<Boolean> =
        BehaviorSubject.createDefault(preferencesRepository.useVulgarInsults)
    val useVulgarInsults: Observable<Boolean> = useVulgarInsultsSubject.hide()

    fun onInsultMeClick() =
        insultSubject.onNext(insultsRepository.getRandomInsult(previousInsult = insultSubject.value ?: ""))

    fun onVulgarInsultsClick(useVulgarInsults: Boolean) {
        preferencesRepository.useVulgarInsults = useVulgarInsults
        useVulgarInsultsSubject.onNext(useVulgarInsults)
    }
}