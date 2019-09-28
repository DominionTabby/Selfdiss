package com.gmail.tabiszdominik.selfdiss

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class MainViewModel : ViewModel() {

    private val navigationCommandSubject: PublishSubject<NavigationCommand> = PublishSubject.create()
    val navigationCommand: Observable<NavigationCommand> = navigationCommandSubject.hide()

    fun openSettings() = navigationCommandSubject.onNext(NavigationCommand.OpenSettings)
}