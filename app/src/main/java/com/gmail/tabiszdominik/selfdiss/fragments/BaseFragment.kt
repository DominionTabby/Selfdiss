package com.gmail.tabiszdominik.selfdiss.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.tabiszdominik.selfdiss.MainViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
abstract class BaseFragment : Fragment() {

    protected val mainViewModel: MainViewModel by sharedViewModel()

    private val disposables = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onStop() {
        disposables.clear()
        super.onStop()
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    abstract fun getLayout(): Int

    protected fun <T : Any> Observable<T>.bind(block: (T) -> Unit) {
        this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { block.invoke(it) }
            .addTo(disposables)
    }
}